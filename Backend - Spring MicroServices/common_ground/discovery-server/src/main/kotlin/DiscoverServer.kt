package com.michaelRichards

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer

@EnableEurekaServer
@SpringBootApplication
class DiscoverServer

fun main(args: Array<String>) {
    runApplication<DiscoverServer>(*args)
}