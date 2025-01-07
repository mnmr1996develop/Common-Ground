package com.michaelRichards.com.michael_richards.userservice.exceptions


sealed class RegistrationExceptions(message: String): RuntimeException(message) {

    class UsernameTaken(username: String): RegistrationExceptions(message = "Username: $username is already taken")

    class EmailTaken(email: String): RegistrationExceptions(message = "E-mail: $email is already taken")
}