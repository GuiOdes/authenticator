package com.guiodes.authenticator.infra.api.request

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank

data class CreateUserRequest(
    @field:NotBlank(message = "Username is required")
    val username: String,
    @field:NotBlank(message = "Password is required")
    val password: String,
    @field:NotBlank(message = "Email is required")
    @field:Email(message = "Email is invalid")
    val email: String
)
