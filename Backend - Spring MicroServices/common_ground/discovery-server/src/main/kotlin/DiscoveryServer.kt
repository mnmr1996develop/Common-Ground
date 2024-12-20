package com.michaelRichards

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer

@EnableEurekaServer
@SpringBootApplication
class DiscoveryServer

fun main(args: Array<String>) {
    runApplication<DiscoveryServer>(*args)
}