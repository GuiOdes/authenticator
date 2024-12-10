package com.guiodes.authenticator.domain.exception

import org.springframework.http.HttpStatus
import kotlin.reflect.KClass

class NotFoundException(
    notFoundClass: KClass<*>
) : BaseException(HttpStatus.NOT_FOUND, "${notFoundClass.simpleName} not found!")
