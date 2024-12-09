package com.guiodes.authenticator.configs

import com.guiodes.authenticator.configs.container.CustomPostgresContainer
import org.springframework.context.ApplicationContextInitializer
import org.springframework.context.ConfigurableApplicationContext

class IntegrationTestsInitializer : ApplicationContextInitializer<ConfigurableApplicationContext> {
    private val postgresContainer = CustomPostgresContainer()

    override fun initialize(applicationContext: ConfigurableApplicationContext) {
        postgresContainer.configure(applicationContext)
    }
}
