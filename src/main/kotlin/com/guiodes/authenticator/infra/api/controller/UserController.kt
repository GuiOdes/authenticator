package com.guiodes.authenticator.infra.api.controller

import com.guiodes.authenticator.application.usecase.CreateUserUseCase
import com.guiodes.authenticator.infra.api.request.CreateUserRequest
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserController(
    private val createUserUseCase: CreateUserUseCase
) {

    @PostMapping
    fun create(request: CreateUserRequest) {
        createUserUseCase.execute(request)
    }
}
