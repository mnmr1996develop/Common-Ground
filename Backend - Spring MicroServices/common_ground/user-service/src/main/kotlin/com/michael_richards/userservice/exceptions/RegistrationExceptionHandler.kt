package com.michaelRichards.com.michael_richards.userservice.exceptions

import com.michaelRichards.com.michael_richards.userservice.dto.APIException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.time.LocalDateTime

@ControllerAdvice
class RegistrationExceptionHandler {

    @ExceptionHandler(value = [RegistrationExceptions.EmailTaken::class])
    fun handleEmailTaken(exception: RegistrationExceptions.EmailTaken): ResponseEntity<Any> {
        val httpStatus = HttpStatus.BAD_REQUEST
        val reason = "EMAIL_TAKEN"

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
                message = "Email is taken"
            )
        }
        return ResponseEntity(apiException, httpStatus)
    }

    @ExceptionHandler(value = [RegistrationExceptions.UsernameTaken::class])
    fun handleUsernameTaken(exception: RegistrationExceptions.UsernameTaken): ResponseEntity<Any>{
        val httpStatus = HttpStatus.BAD_REQUEST
        val reason = "USERNAME_TAKEN"
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
                message = "Username is taken"
            )
        }
        return ResponseEntity(apiException, httpStatus)
    }

}