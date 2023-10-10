package com.junocoding.bank.repositories

import com.junocoding.bank.models.wishList
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface wishListRepository:JpaRepository<wishList,Long> {
    fun findByUserId(userId:Long):List<wishList>
    //fun findbyId(ProductId:Long):List<wishList>
}