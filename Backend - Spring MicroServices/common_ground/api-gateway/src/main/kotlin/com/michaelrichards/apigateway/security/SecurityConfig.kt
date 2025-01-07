package com.michaelRichards.com.michaelrichards.apigateway.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity
import org.springframework.security.config.web.server.ServerHttpSecurity
import org.springframework.security.web.server.SecurityWebFilterChain

@Configuration
@EnableWebFluxSecurity
class SecurityConfig {

    @Bean
    fun securityFilterChain(serverHttpSecurity: ServerHttpSecurity): SecurityWebFilterChain =
        serverHttpSecurity
            .csrf{it.disable()}
            .authorizeExchange { exchange ->
                exchange
                    .pathMatchers("(/eureka/**")
                    .permitAll()
                    .pathMatchers("api/v1/users/**")
                    .permitAll()
                    .anyExchange()
                    .authenticated()

            }.oauth2ResourceServer {
                it.jwt(Customizer.withDefaults())
            }
            .build()

}