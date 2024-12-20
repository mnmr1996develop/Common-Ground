package com.michaelRichards.com.michaelrichards.apigateway.security

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity
import org.springframework.security.config.web.server.ServerHttpSecurity
import org.springframework.security.web.server.SecurityWebFilterChain

@Configuration
@EnableWebFluxSecurity
class SecurityConfig {

    fun securityFilterChain(serverHttpSecurity: ServerHttpSecurity): SecurityWebFilterChain =
        serverHttpSecurity
            .csrf(ServerHttpSecurity.CsrfSpec::disable)
            .authorizeExchange { exchange ->
                exchange
                    .pathMatchers("(/eureka/**")
                    .permitAll()
                    .pathMatchers("api/v1/users/register")
                    .permitAll()
                    .anyExchange()
                    .authenticated()

            }.oauth2ResourceServer {
                it.jwt(Customizer.withDefaults())
            }
            .build()

}