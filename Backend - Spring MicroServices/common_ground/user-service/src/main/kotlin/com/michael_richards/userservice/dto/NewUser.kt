package com.michaelRichards.com.michael_richards.userservice.dto

import java.time.LocalDate

data class NewUser(
    val firstName: String,
    val lastName: String,
    val username: String,
    val email: String,
    val birthday: LocalDate,
    val password: String
)