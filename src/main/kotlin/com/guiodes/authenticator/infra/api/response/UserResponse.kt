package com.guiodes.authenticator.infra.api.response

import com.guiodes.authenticator.domain.model.User
import java.util.UUID

data class UserResponse(
    val id: UUID,
    val username: String
) {
    companion object {
        fun from(user: User) = UserResponse(
            id = user.id,
            username = user.username
        )
    }
}
