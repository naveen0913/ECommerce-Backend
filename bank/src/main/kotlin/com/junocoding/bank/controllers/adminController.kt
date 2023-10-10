package com.junocoding.bank.controllers

import com.junocoding.bank.DTOS.adminRegister
import com.junocoding.bank.DTOS.adminlogin
import com.junocoding.bank.models.admin
import com.junocoding.bank.service.adminService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


@RestController
@RequestMapping("/admin")
@CrossOrigin("*")
class adminController (private val adminService:adminService){

    @PostMapping("/signup") //api for admin registration
    fun register(@RequestBody body:adminRegister): ResponseEntity<admin> {
        val Admin=admin()
        Admin.email=body.email
        Admin.password=body.password
        return ResponseEntity.ok(adminService.save(Admin))
       // println(message = "Admin registered")
    }

    @PostMapping("/login")  //api for user login
    fun login(@RequestBody body:adminlogin,response:HttpServletResponse):ResponseEntity<Any>{
        val Admin=adminService.findByEmail(body.email)
            ?:return ResponseEntity.badRequest().body("admin not found")
        return if(Admin.password!=body.password){
            ResponseEntity.badRequest().body("Inavlid password")
        }else{
            ResponseEntity.ok(Admin.email)
            ResponseEntity.ok("Admin login success")
        }
    }
    @PostMapping("/logout")  //api for user logout
    fun logout(request:HttpServletRequest):ResponseEntity<String>{
        request.session.invalidate()
        println("Admin logout successfully")
        return ResponseEntity.ok("admin logout successfull")
    }
}