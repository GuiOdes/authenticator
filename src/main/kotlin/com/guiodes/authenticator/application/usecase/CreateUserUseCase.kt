package com.guiodes.authenticator.application.usecase

import com.guiodes.authenticator.infra.api.request.CreateUserRequest
import com.guiodes.authenticator.infra.repository.UserRepository
import org.springframework.stereotype.Component

@Component
class CreateUserUseCase(
    private val repository: UserRepository
) {

    fun execute(request: CreateUserRequest) {
        // TODO validate and encrypt password
        repository.save(request)
    }
}
