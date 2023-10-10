package com.junocoding.bank.service

import com.junocoding.bank.models.wishList
import com.junocoding.bank.repositories.productRepository
import com.junocoding.bank.repositories.wishListRepository
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import javax.persistence.EntityNotFoundException

@Service
class wishlistService (
    private val wishListRepository: wishListRepository,
    private val productRepository: productRepository
){
    fun deleteWishlistitem(id:Long){
        val item=wishListRepository.findById(id)
        if(item.isPresent){
            wishListRepository.deleteById(id)
        }else{
            throw EntityNotFoundException()
        }
    }
    /*
    fun getAllitemsWishlist(): List<wishList> {
        val userItems=wishListRepository.findAll()
        return userItems
    }
     */
    fun getallItemsbyuserwishlist(userId:Long):List<wishList>{
        val user=wishListRepository.findByUserId(userId)
        return user
    }


}
