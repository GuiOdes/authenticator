package com.guiodes.authenticator.configs

import org.flywaydb.core.Flyway
import org.junit.jupiter.api.BeforeEach
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.TestPropertySource
import org.testcontainers.junit.jupiter.Testcontainers


@SpringBootTest(webEnvironment = RANDOM_PORT)
@Testcontainers
@ContextConfiguration(initializers = [IntegrationTestsInitializer::class])
@TestPropertySource(properties = ["spring.flyway.clean-disabled=false"])
abstract class IntegrationTests {

    @Autowired
    private lateinit var flyway: Flyway

    @BeforeEach
    fun cleanDatabase() {
        flyway.clean()
        flyway.migrate()
    }
}