package com.junocoding.bank.service

import com.junocoding.bank.models.*
import com.junocoding.bank.repositories.*
import org.springframework.stereotype.Service
import java.util.*
import javax.persistence.EntityNotFoundException

@Service
class orderService(
    private val orderRepository: orderRepository,
    private val productService: productService,
    private val userRepository: userRepository,
    private val productRepository: productRepository,
) {
   //geting all orders by userid
    fun getAllOrders(userId: Long):List<Order>{
        val orders=orderRepository.findByUserId(userId)
        return orders
    }
    fun getOrderById(id:Long): Optional<Order> {
        return orderRepository.findById(id)
    }
    //deleting order
    fun deleteOrder(id:Long){
        val order=orderRepository.findById(id)
        if (order.isPresent){
            orderRepository.deleteById(id)
        }else{
            throw EntityNotFoundException("order not found")
        }
    }
}