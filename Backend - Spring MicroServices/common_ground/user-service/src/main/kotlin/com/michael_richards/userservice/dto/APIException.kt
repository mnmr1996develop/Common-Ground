package com.michaelRichards.com.michael_richards.userservice.dto


import org.springframework.http.HttpStatus
import java.time.LocalDateTime

data class APIException(
    val status: HttpStatus,
    val timeStamp: LocalDateTime,
    val reason: String,
    val message: String
)
