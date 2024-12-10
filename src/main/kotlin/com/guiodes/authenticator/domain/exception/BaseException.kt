package com.guiodes.authenticator.domain.exception

import org.springframework.http.HttpStatus

open class BaseException(
    val code: HttpStatus,
    override val message: String
) : RuntimeException(message)
