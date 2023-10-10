package com.junocoding.bank.repositories

import com.junocoding.bank.models.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface userRepository:JpaRepository<User,Long>{
    fun findByEmail(email:String):User?
    //fun findById(id:Long):User?
}