package com.guiodes.authenticator.infra.api.controller

import com.guiodes.authenticator.application.usecase.AuthenticateUseCase
import com.guiodes.authenticator.infra.api.request.LoginRequest
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/login")
class LoginController(
    private val authenticateUseCase: AuthenticateUseCase
) {

    @PostMapping
    fun login(@RequestBody loginRequest: LoginRequest) {
        authenticateUseCase.execute(loginRequest)
    }
}