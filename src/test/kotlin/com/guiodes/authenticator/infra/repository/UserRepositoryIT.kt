package com.guiodes.authenticator.infra.repository

import com.guiodes.authenticator.configs.IntegrationTests
import com.guiodes.authenticator.fixture.UserFixture
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

class UserRepositoryIT(
    @Autowired private val userRepository: UserRepository
) : IntegrationTests() {

    @Test
    fun `Should create a user`() {
        val request = UserFixture.createModel()

        assertThat(userRepository.findByUsername(request.username)).isNull()

        userRepository.save(request)

        userRepository.findByUsername(request.username).also {
            assertThat(it).isNotNull
            assertThat(it!!.username).isEqualTo(request.username)
            assertThat(it.email).isEqualTo(request.email)
        }
    }
}
