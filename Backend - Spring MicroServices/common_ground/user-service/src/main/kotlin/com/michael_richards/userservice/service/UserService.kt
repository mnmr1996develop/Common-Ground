package com.michaelRichards.com.michael_richards.userservice.service

import com.michaelRichards.com.michael_richards.userservice.dto.NewUser
import org.keycloak.representations.idm.UserRepresentation

interface UserService {
    fun registerUser(newUser: NewUser)

    fun getUserById(userId: String): UserRepresentation

    fun deleteUserById(userId: String)
}