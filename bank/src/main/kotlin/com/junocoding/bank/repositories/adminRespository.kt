package com.junocoding.bank.repositories

import com.junocoding.bank.models.admin
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface adminRepository:CrudRepository<admin,Int>{
    fun findByEmail(email:String):admin?
    //fun findByUsername(username:String):admin?
}