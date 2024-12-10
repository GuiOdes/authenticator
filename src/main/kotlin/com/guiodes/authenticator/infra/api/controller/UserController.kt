package com.guiodes.authenticator.infra.api.controller

import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.oauth2.core.user.OAuth2User
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserController {

    @GetMapping
    fun get(@AuthenticationPrincipal user: OAuth2User) = "Welcome, ${user.attributes["name"]}!"
}
