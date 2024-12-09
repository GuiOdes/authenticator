package com.guiodes.authenticator.fixture

import com.guiodes.authenticator.domain.model.User
import com.guiodes.authenticator.infra.api.request.CreateUserRequest
import java.time.LocalDateTime
import java.util.UUID

object UserFixture {

    fun createModel(
        id: UUID = UUID.randomUUID(),
        username: String = "username",
        password: String = "password",
        email: String = "email@email.com",
        createdAt: LocalDateTime = LocalDateTime.now(),
        updatedAt: LocalDateTime = LocalDateTime.now()
    ) = User(
        id = id,
        username = username,
        password = password,
        email = email,
        createdAt = createdAt,
        updatedAt = updatedAt
    )

    fun createRequest(
        username: String = "username",
        password: String = "password",
        email: String = "email@email.com"
    ) = CreateUserRequest(
        username = username,
        password = password,
        email = email
    )
}
