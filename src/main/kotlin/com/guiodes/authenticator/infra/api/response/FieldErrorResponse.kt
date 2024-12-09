package com.guiodes.authenticator.infra.api.response

import org.springframework.validation.FieldError

data class FieldErrorResponse(
    val message: String,
    val fieldName: String
) {
    constructor(fieldError: FieldError) : this(fieldError.defaultMessage ?: "", fieldError.field)
}