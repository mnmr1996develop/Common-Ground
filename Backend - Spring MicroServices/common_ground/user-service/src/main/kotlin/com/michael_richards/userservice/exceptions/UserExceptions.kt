package com.michaelRichards.com.michael_richards.userservice.exceptions


sealed class UserExceptions(message: String): RuntimeException(message) {

    class UsernameNotFound(username: String): UserExceptions(message = "Username: $username not found")

    class EmailNotFound(email: String): UserExceptions(message = "E-mail: $email not found")
}