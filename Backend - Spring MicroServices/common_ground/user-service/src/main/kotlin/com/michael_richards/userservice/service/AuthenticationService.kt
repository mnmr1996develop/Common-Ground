package com.michaelRichards.com.michael_richards.userservice.service

import com.michaelRichards.com.michael_richards.userservice.dto.NewUser
import org.keycloak.representations.idm.UserRepresentation

interface AuthenticationService {
    fun registerUser(newUser: NewUser)

    fun getUserById(userId: String): UserRepresentation

    fun deleteUserById(userId: String)

    fun getAllUsers(): List<UserRepresentation>

    fun getUserByUsername(username: String): UserRepresentation

    fun search(q: String): List<UserRepresentation>
}