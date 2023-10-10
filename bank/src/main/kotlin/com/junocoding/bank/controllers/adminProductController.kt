package com.junocoding.bank.controllers

import com.junocoding.bank.DTOS.addProduct
import com.junocoding.bank.models.Product
import com.junocoding.bank.service.productService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/admin")
class adminProductController (private val productService: productService){

    @PostMapping("/add")  //api for adding products by admin
    fun addingProduct(@RequestBody product: Product):Product{
        return productService.addProduct(product)
    }

    @GetMapping("/products")  //api for getting all products by admin
    fun getAllproducts(product:Product):List<Product>{
        return productService.getAllProducts(product)
    }
    @PutMapping("/product/{id}")  //api for updating  products by admin
    fun updateProduct(@PathVariable id:Long,@RequestBody updateproduct:addProduct):ResponseEntity<Product>{
        val updatedProduct=productService.updateProduct(id,updateproduct)
        println("Updated successfully")
        return ResponseEntity.ok(updatedProduct)
    }
    @DeleteMapping("/product/{id}")  //api for deleting products by admin
    fun deleteProduct(@PathVariable id:Long){
        return productService.deleteProduct(id)
    }
}