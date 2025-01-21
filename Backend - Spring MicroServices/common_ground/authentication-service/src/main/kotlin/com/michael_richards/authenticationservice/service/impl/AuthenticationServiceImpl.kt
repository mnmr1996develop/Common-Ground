package com.michaelRichards.com.michael_richards.userservice.service.impl

import com.michaelRichards.com.michael_richards.userservice.dto.NewUser
import com.michaelRichards.com.michael_richards.userservice.exceptions.RegistrationExceptions
import com.michaelRichards.com.michael_richards.userservice.exceptions.UserExceptions
import org.keycloak.admin.client.Keycloak
import com.michaelRichards.com.michael_richards.userservice.service.AuthenticationService
import org.keycloak.admin.client.resource.UsersResource
import org.keycloak.representations.idm.CredentialRepresentation
import org.keycloak.representations.idm.UserRepresentation
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Service
class AuthenticationServiceImpl(
    private val keycloak: Keycloak
): AuthenticationService {

    @Value("\${app.keycloak.realm}")
    private lateinit var realm: String

    private val logger = LoggerFactory.getLogger(AuthenticationServiceImpl::class.java)

    override fun registerUser(newUser: NewUser) {

        logger.info(newUser.toString())

        isEmailTaken(newUser.email)
        isUsernameTakenResource(newUser.username)


        val user = UserRepresentation().apply {
            this.isEnabled = true
            this.firstName = newUser.firstName
            this.lastName = newUser.lastName
            this.email = newUser.email
            this.username = newUser.username

            val credentialRepresentation = CredentialRepresentation().apply {
                this.type = CredentialRepresentation.PASSWORD
                this.value = newUser.password
                this.isTemporary = false
            }

            this.credentials = listOf(credentialRepresentation)


            val birthday: String = formatLocalDateToString(newUser.birthday)
            this.attributes = mapOf("birthday" to listOf(birthday))
        }

        val response = getUsersResource().create(user)

        if (response.status == 201){

            logger.info("User ${newUser.username} successfully created")
        }
        else {
            val errorMessage = response.readEntity(String::class.java)
            logger.error("Failed to create user. Status: ${response.status}, Reason: $errorMessage")
            throw RuntimeException(errorMessage)
        }

    }



    override fun getUserById(userId: String): UserRepresentation = getUsersResource().get(userId).toRepresentation()


    override fun deleteUserById(userId: String) {
        getUsersResource().delete(userId)
    }

    override fun getAllUsers(): List<UserRepresentation> = getUsersResource().list()

    override fun getUserByUsername(username: String): UserRepresentation {
        val userRep = getUsersResource().searchByUsername(username, true)
        if (userRep.size == 1)
            return userRep[0]
        else
            throw UserExceptions.UsernameNotFound(username)
    }

    override fun search(q: String): List<UserRepresentation>  = getUsersResource().search(q)


    private fun getUsersResource(): UsersResource = keycloak.realm(realm).users()

    private fun formatLocalDateToString(date: LocalDate): String {
        val formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy")
        return date.format(formatter)
    }

    //throws exception if username is not taken
    private fun isEmailTaken(email: String) {
        val userResources: UsersResource = getUsersResource()

        val usersList: List<UserRepresentation> = userResources.searchByEmail(email, true)

        if (usersList.isNotEmpty()){
            throw RegistrationExceptions.EmailTaken(email)
        }
    }

    private fun isUsernameTakenResource(username: String){

        val usersList: List<UserRepresentation> = getUsersResource().searchByUsername(username, true)

        if (usersList.isNotEmpty()){
            throw RegistrationExceptions.UsernameTaken(username)
        }
    }
}