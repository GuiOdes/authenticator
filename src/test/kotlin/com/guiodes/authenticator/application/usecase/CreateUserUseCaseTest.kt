package com.guiodes.authenticator.application.usecase

import com.guiodes.authenticator.application.gateway.UserGateway
import com.guiodes.authenticator.configs.UnitTests
import com.guiodes.authenticator.infra.api.request.CreateUserRequest
import io.mockk.Runs
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.just
import io.mockk.verify
import org.junit.jupiter.api.Test

class CreateUserUseCaseTest(
    @MockK private val userGateway: UserGateway
) : UnitTests() {

    @InjectMockKs
    private lateinit var createUserUseCase: CreateUserUseCase

    @Test
    fun `Should create user`() {
        val request = CreateUserRequest(
            email = "email@email.com",
            username = "john.doe",
            password = "123456"
        )

        every { userGateway.save(request) } just Runs

        createUserUseCase.execute(request)

        verify(exactly = 1) { userGateway.save(request) }
    }
}
