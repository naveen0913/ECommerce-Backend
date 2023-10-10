package com.junocoding.bank.controllers

import com.junocoding.bank.DTOS.UserOrder
import com.junocoding.bank.models.Order
import com.junocoding.bank.repositories.orderRepository
import com.junocoding.bank.repositories.productRepository
import com.junocoding.bank.repositories.userRepository
import com.junocoding.bank.service.orderService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate
import java.time.LocalTime
import java.util.*
import kotlin.NoSuchElementException


@RestController
@RequestMapping("/order") //placing order api
@CrossOrigin("*")
class orderController (private val orderService: orderService,
                       private val  orderRepository: orderRepository,
                       private val productRepository: productRepository,private val userRepository: userRepository
    )
{
    @PostMapping("/place/{userId}/{id}")
    fun placeOrder(@PathVariable id: Long,@PathVariable userId:Long,@RequestBody order:UserOrder): ResponseEntity<Order> {

        val product=productRepository.findById(id).orElseThrow { NoSuchElementException("Product not found") }
        val existedItem=orderRepository.findByUserId(userId).find { it.product.id==id }
        if (existedItem!=null){
             println("product already Exists")
        }
        val newOrder=Order(
            product=product,
            userId = userId,
            orderedTime = LocalTime.now(),
            orderedDate = LocalDate.now(),
            totalPrice = product.offerprice,
            productName = product.name,
            payment = "Cash On Delivery",
            brandName = product.brandName,
            status = "Order Placed Successfully",
            phone = order.phone,
            address = order.address,
            category = product.categoryName,
            name = order.name,
            size = order.size,
            quantity = order.quantity

        )
        //newOrder.Quantity= order.Quantity
        //newOrder.name=order.name
        //newOrder.Size=order.Size
        //newOrder.address=order.address
        //newOrder.phone=order.phone
        orderRepository.save(newOrder)
        return ResponseEntity.ok(newOrder)
    }

    @GetMapping("/myorders/{userId}")  //getting all orders by user
    fun getallOrders(@PathVariable userId: Long):List<Order>{
        return orderService.getAllOrders(userId)
    }
    @GetMapping("/{id}")  //getting order by id
    fun getorderById(@PathVariable id:Long): ResponseEntity<Optional<Order>> {
        val order=orderService.getOrderById(id)
        if (order==null){
            ResponseEntity.badRequest().body("No order found")
        }
        return ResponseEntity.ok(order)
    }
    @DeleteMapping("/del/{id}")  //deleting order by id
    fun deleteOrder(@PathVariable id:Long): ResponseEntity<*> {
        orderService.deleteOrder(id)
        return ResponseEntity.ok("Order deleted successfully")
    }
}


