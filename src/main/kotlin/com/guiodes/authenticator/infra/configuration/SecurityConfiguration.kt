package com.guiodes.authenticator.infra.configuration

import com.guiodes.authenticator.application.usecase.Oidc2UserUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.SecurityFilterChain

@Configuration
class SecurityConfiguration(
    private val oidc2UserUseCase: Oidc2UserUseCase
) {

    @Bean
    fun httpConfig(httpSecurity: HttpSecurity): SecurityFilterChain = httpSecurity
        .authorizeHttpRequests {
            it
                .anyRequest()
                .authenticated()
        }
        .oauth2Login { login ->
            login.defaultSuccessUrl("/user", true)
            login.userInfoEndpoint { infoEndpoint ->
                infoEndpoint.oidcUserService(oidc2UserUseCase)
            }
        }
        .logout { logout ->
            logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")
                .permitAll()
                .invalidateHttpSession(true)
                .clearAuthentication(true)
        }.build()
}
