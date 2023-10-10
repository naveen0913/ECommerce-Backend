package com.junocoding.bank.controllers

import com.junocoding.bank.models.Product
import com.junocoding.bank.models.wishList
import com.junocoding.bank.repositories.productRepository
import com.junocoding.bank.repositories.wishListRepository
import com.junocoding.bank.service.wishlistService
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@CrossOrigin("*")
@RestController
@RequestMapping("/products/wishlist")
class wishlistController(private val wishListRepository: wishListRepository,
                         private val productRepository: productRepository,
    private val wishlistService: wishlistService
    ){
    //adding item to wishlist
    @PostMapping("/add/{userId}/{id}")
    fun addtoWishlist(@PathVariable id:Long,@PathVariable userId:Long): Any/*ResponseEntity<String>*/{
        val product=productRepository.findById(id)
            .orElseThrow { NoSuchElementException("product not found") }
        val exiteditem=wishListRepository.findByUserId(userId).find { it.product.id==id }
        if(exiteditem!=null){
            //return ResponseEntity.badRequest().body("Product already exists")
            return "Product already exists"
        }
        val newItem=wishList(product =product, userId = userId)
        return wishListRepository.save(newItem)
        //return ResponseEntity.ok("product added to wishlist")
    }
    //removing item form wishlist
    @DeleteMapping("/del/{id}")
    fun deleteWishlistItem(@PathVariable id:Long){
        return wishlistService.deleteWishlistitem(id)
    }
    //getting all wishlist items
    @GetMapping("/items/{userId}")
    fun getAllWishlistItems(@PathVariable userId: Long): List<wishList> {
        return wishlistService.getallItemsbyuserwishlist(userId)
    }

}