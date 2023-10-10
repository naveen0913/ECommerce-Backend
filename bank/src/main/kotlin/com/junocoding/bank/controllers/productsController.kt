package com.junocoding.bank.controllers

import com.junocoding.bank.models.Product
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import com.junocoding.bank.service.productService
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import java.util.Optional

@RestController
@RequestMapping("")
@CrossOrigin("*")
class productsController(private val productService:productService){

    @GetMapping("/products") //getting all products by anyone (users)
    fun getAllProducts(product:Product):List<Product>{
        return productService.getAllProducts(product)
    }
    @GetMapping("/products/product/{id}") //getting product detail by id
    fun getProductbyId(@PathVariable id:Long): Optional<Product> {
        return productService.getProductByID(id)
    }

}

