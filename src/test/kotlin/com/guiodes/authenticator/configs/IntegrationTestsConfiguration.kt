package com.guiodes.authenticator.configs

import org.springframework.context.ConfigurableApplicationContext

interface IntegrationTestsConfiguration {
    fun configure(applicationContext: ConfigurableApplicationContext)
}
