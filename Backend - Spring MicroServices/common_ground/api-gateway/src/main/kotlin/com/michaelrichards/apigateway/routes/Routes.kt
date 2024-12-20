package com.michaelRichards.com.michaelrichards.apigateway.routes

import org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions
import org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.function.RequestPredicates
import org.springframework.web.servlet.function.RouterFunction
import org.springframework.web.servlet.function.ServerResponse

@Configuration
class Routes {

    @Bean
    fun userServiceRoute(): RouterFunction<ServerResponse> =
        GatewayRouterFunctions.route("user-service")
            .route(RequestPredicates.path("/api/v1/users"), HandlerFunctions.http("http://localhost:9090"))
            .build()

}