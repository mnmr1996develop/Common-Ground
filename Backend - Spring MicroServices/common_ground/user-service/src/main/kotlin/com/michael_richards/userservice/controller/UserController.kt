package com.michaelRichards.com.michael_richards.userservice.controller

import com.michaelRichards.com.michael_richards.userservice.dto.NewUser
import com.michaelRichards.com.michael_richards.userservice.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("api/v1/users")
class UserController(
    private val userService: UserService
) {

    @PostMapping
    fun registerUser(
        @RequestBody newUser: NewUser
    ): ResponseEntity<Unit> {

        return ResponseEntity.status(HttpStatus.CREATED).body(userService.registerUser(newUser))
    }
}