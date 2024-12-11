package com.michaelRichards

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class UserMicroService

fun main(args: Array<String>) {
    runApplication<UserMicroService>(*args)
}