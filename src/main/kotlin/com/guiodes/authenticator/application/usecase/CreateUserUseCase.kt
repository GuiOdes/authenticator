package com.guiodes.authenticator.application.usecase

import com.guiodes.authenticator.application.gateway.UserGateway
import com.guiodes.authenticator.infra.api.request.CreateUserRequest
import org.springframework.stereotype.Component

@Component
class CreateUserUseCase(
    private val gateway: UserGateway
) {

    fun execute(request: CreateUserRequest) {
        // TODO validate and encrypt password
        gateway.save(request)
    }
}
