package com.michaelRichards.com.michael_richards.userservice.exceptions

import com.michaelRichards.com.michael_richards.userservice.dto.APIException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.time.LocalDateTime

@ControllerAdvice
class UserExceptionHandler {

    @ExceptionHandler(value = [UserExceptions.EmailNotFound::class])
    fun handleEmailNotFound(exception: UserExceptions.EmailNotFound): ResponseEntity<APIException> {
        val httpStatus = HttpStatus.BAD_REQUEST
        val reason = "EMAIL_NOT_FOUND"

        val apiException = exception.message?.let {
            APIException(
                status = httpStatus,
                timeStamp = LocalDateTime.now(),
                reason = reason,
                message = it
            )
        } ?: run {
            APIException(
                status = httpStatus,
                timeStamp = LocalDateTime.now(),
                reason = reason,
                message = "Email not found"
            )
        }
        return ResponseEntity(apiException, httpStatus)
    }

    @ExceptionHandler(value = [UserExceptions.UsernameNotFound::class])
    fun handleUsernameNotFound(exception: UserExceptions.UsernameNotFound): ResponseEntity<APIException>{
        val httpStatus = HttpStatus.BAD_REQUEST
        val reason = "USERNAME_NOT_FOUND"
        val apiException = exception.message?.let {
            APIException(
                status = httpStatus,
                timeStamp = LocalDateTime.now(),
                reason = reason,
                message = it
            )
        } ?: run {
            APIException(
                status = httpStatus,
                timeStamp = LocalDateTime.now(),
                reason = reason,
                message = "Username not found"
            )
        }
        return ResponseEntity(apiException, httpStatus)
    }

}