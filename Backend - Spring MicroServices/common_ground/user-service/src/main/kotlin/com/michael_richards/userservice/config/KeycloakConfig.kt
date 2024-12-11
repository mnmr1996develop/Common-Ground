package com.michaelRichards.com.michael_richards.userservice.config

import org.keycloak.admin.client.Keycloak
import org.keycloak.admin.client.KeycloakBuilder
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class KeycloakConfig {

    @Value("\${app.keycloak.admin.clientId}")
    private lateinit var clientId: String

    @Value("\${app.keycloak.admin.clientSecret}")
    private lateinit var clientSecret: String

    @Value("\${app.keycloak.realm}")
    private lateinit var realm: String

    @Value("\${app.keycloak.serverUrl}")
    private lateinit var serverUrl: String

    @Bean
    fun keycloak(): Keycloak = KeycloakBuilder.builder()
        .clientSecret(clientSecret)
        .clientId(clientId)
        .grantType("client_credentials")
        .realm(realm)
        .serverUrl(serverUrl)
        .build()

}