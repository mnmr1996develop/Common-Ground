package com.michaelRichards

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class APIGateway

fun main(args: Array<String>) {
    runApplication<APIGateway>(*args)
}