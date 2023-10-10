package com.junocoding.bank.repositories

import com.junocoding.bank.models.cartItem
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface cartRespository:JpaRepository<cartItem,Long>{
    //fun findbyId(productId: Long):cartItem?
    //abstract fun findById(product: Product?): Optional<cartItem>
}

