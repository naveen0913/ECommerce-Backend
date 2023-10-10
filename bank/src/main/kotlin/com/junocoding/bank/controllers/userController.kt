package com.junocoding.bank.controllers

import com.junocoding.bank.DTOS.userLogin
import com.junocoding.bank.DTOS.userRegister
import com.junocoding.bank.models.User
import com.junocoding.bank.service.userService
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import java.time.LocalDate
import java.util.*
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Controller
@RestController
@RequestMapping("/user")
@CrossOrigin("*")
class userController(private val userService: userService) {
    @PostMapping("/signup") //api for user signup
    fun register(@RequestBody body: userRegister) : ResponseEntity<User> {
        val user= User()
        user.name=body.name
        user.email=body.email
        user.password=body.password
        user.date= LocalDate.now()
        println("user registration successful")
        return ResponseEntity.ok(userService.save(user))

    }
    @PostMapping("/login")  //api for user login
    fun login(@RequestBody body:userLogin, response: HttpServletResponse):ResponseEntity<Any> {

        val existeduser = userService.findByEmail(body.email)
            ?: return ResponseEntity.badRequest().body("user not found")
        return if (existeduser.password!=body.password) {
            ResponseEntity.badRequest().body("Invalid password")
        } else {
            println("user logged in")
            ResponseEntity.ok(existeduser)
        }

    }
    @PostMapping("/logout")  //api for user logout
    fun logout(request:HttpServletRequest):ResponseEntity<String>{
        request.session.invalidate()
        return ResponseEntity.ok("User logout successfully")
    }
    @GetMapping("/{id}")  //api for getting user
    fun GetUserDetails(@PathVariable id:Long): Optional<User> {
        val existedUser=userService.findUser(id)
        return existedUser
    }
    @PutMapping("/{id}/update")
    fun updateUser(@PathVariable id: Long,@RequestBody body:userRegister): User {
        val updateduser=userService.updateUser(id,body)
        return updateduser
    }

}


