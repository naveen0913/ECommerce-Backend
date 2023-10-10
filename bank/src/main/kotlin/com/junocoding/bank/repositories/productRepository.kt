package com.junocoding.bank.repositories


import com.junocoding.bank.models.Product
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface productRepository :JpaRepository<Product, Long> {
    //fun findByID(id: Long): Optional<Product>
     //fun findById(id:Long): Product?
    /// fun saveProduct(product: Product): Product
}