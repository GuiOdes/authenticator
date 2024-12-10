package com.guiodes.authenticator.domain.model

import java.time.LocalDateTime
import java.util.UUID

data class User(
    val id: UUID,
    val username: String,
    val email: String,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
)
