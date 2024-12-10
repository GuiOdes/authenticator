package com.guiodes.authenticator.application.usecase

import com.guiodes.authenticator.domain.exception.NotFoundException
import com.guiodes.authenticator.domain.model.User
import com.guiodes.authenticator.infra.repository.UserRepository
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService
import org.springframework.security.oauth2.core.oidc.user.OidcUser
import org.springframework.stereotype.Component
import java.time.LocalDateTime
import java.util.UUID

@Component
class Oidc2UserUseCase(
    private val userRepository: UserRepository
) : OidcUserService() {

    override fun loadUser(userRequest: OidcUserRequest?): OidcUser {
        val user = super.loadUser(userRequest)
        val username: String = user.getAttribute("email")
            ?: throw NotFoundException(OidcUserRequest::class)

        userRepository.findByUsername(username) ?: {
            val now = LocalDateTime.now()

            userRepository.save(
                User(
                    id = UUID.randomUUID(),
                    email = username,
                    username = username,
                    createdAt = now,
                    updatedAt = now
                )
            )
        }

        return user
    }
}
