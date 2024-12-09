package com.guiodes.authenticator.infra.api.controller

import com.guiodes.authenticator.application.usecase.CreateUserUseCase
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserController(
    private val createUserUseCase: CreateUserUseCase
) {
}