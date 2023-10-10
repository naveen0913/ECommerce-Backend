package com.junocoding.bank.service

import com.junocoding.bank.models.admin
import com.junocoding.bank.repositories.adminRepository
import org.springframework.stereotype.Service
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer


@Service
class adminService(private val adminrepository:adminRepository) {

    fun save(admin:admin):admin{
        return adminrepository.save(admin)
    }

   fun findByEmail(admin:String):admin?{
       return adminrepository.findByEmail(admin)
   }

}
