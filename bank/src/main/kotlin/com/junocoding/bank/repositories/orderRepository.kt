package com.junocoding.bank.repositories

import com.junocoding.bank.models.Order
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface orderRepository:JpaRepository<Order,Long> {
    fun findByUserId(userId: Long):List<Order>

}