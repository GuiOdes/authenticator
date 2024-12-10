package com.guiodes.authenticator.application.gateway

import com.guiodes.authenticator.domain.model.User

interface UserGateway {
    fun save(user: User)
}
