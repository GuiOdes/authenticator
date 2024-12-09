package com.guiodes.authenticator.application.gateway

import com.guiodes.authenticator.infra.api.request.CreateUserRequest

interface UserGateway {
    fun save(request: CreateUserRequest)
}
