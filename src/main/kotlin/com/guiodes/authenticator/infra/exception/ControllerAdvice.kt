package com.guiodes.authenticator.infra.exception

import com.guiodes.authenticator.infra.api.response.FieldErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleMethodArgumentNotValidException(
        ex: MethodArgumentNotValidException
    ): Map<String, List<FieldErrorResponse>> {
        return mapOf("errors" to ex.fieldErrors.map { FieldErrorResponse(it) })
    }
}
