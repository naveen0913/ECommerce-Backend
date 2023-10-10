package com.junocoding.bank.service
import com.junocoding.bank.DTOS.userRegister
import com.junocoding.bank.models.User
import com.junocoding.bank.repositories.userRepository
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RequestBody
import java.util.*
import kotlin.NoSuchElementException

@Service
class userService (private val userRepository: userRepository){

    fun save(user :User):User{
        return userRepository.save(user)
    }
    fun findByEmail(email:String):User?{
        return this.userRepository.findByEmail(email)

    }
    fun findUser(id:Long): Optional<User> {
        return userRepository.findById(id)
    }
    fun updateUser(id:Long,@RequestBody body:userRegister): User {
        val existeduser=userRepository.findById(id).orElseThrow { NoSuchElementException("No user found")}
        body.name.let { existeduser.name=it }
        body.email.let { existeduser.email=it }
        body.password.let { existeduser.password=it }
        val updatedUser=userRepository.save(existeduser)
        return updatedUser
    }
}