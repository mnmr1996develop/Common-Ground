package com.michaelRichards.com.michael_richards.userservice.controller

import com.michaelRichards.com.michael_richards.userservice.dto.NewUser
import com.michaelRichards.com.michael_richards.userservice.service.AuthenticationService
import org.keycloak.representations.idm.UserRepresentation
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
@RequestMapping("api/v1/users")
class UserController(
    private val authenticationService: AuthenticationService
) {

    @PostMapping("/register")
    fun registerUser(
        @RequestBody newUser: NewUser
    ): ResponseEntity<Unit> {

        return ResponseEntity.status(HttpStatus.CREATED).body(authenticationService.registerUser(newUser))
    }

    @GetMapping("{username}")
    fun getUser(@PathVariable("username") username: String): ResponseEntity<UserRepresentation> =
        ResponseEntity.status(HttpStatus.OK).body(authenticationService.getUserByUsername(username))

    @GetMapping("/search")
    fun searchUser(@RequestParam("q") q: String) : ResponseEntity<List<UserRepresentation>> =
        ResponseEntity.status(HttpStatus.OK).body(authenticationService.search(q))

    @PreAuthorize("hasRole('admin')")
    @GetMapping
    fun getAllUsers(): ResponseEntity<List<UserRepresentation>>{
        return ResponseEntity.status(HttpStatus.OK).body(authenticationService.getAllUsers())
    }
}