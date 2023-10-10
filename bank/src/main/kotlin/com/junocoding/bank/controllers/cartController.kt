package com.junocoding.bank.controllers

import com.junocoding.bank.DTOS.addCart
import com.junocoding.bank.models.cartItem
import com.junocoding.bank.repositories.cartRespository
import com.junocoding.bank.repositories.productRepository
import com.junocoding.bank.service.cartService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.Optional

@RestController
@RequestMapping("/products/cart")
@CrossOrigin("*")
class cartController(private val productRepository: productRepository,private val cartRespository: cartRespository,private val cartService: cartService){

     /*
    @PostMapping("/add/{productId}")
    fun addTOCart(@PathVariable productId:Long,@RequestBody body:cartItem):ResponseEntity<String>{
        return cartService.addtocart(productId)
    }
     */
    @PostMapping("/add/{productId}")  //api for adding product to cart
    fun addtocart(@PathVariable productId:Long,/*@RequestParam quantity:Int,*/@RequestBody body:addCart){
       val product=productRepository.findById(productId)
           .orElseThrow{NoSuchElementException("product not found")}
        val existeditem=product.cartItems.find { it.product.id==product.id }
        existeditem?.quantity=body.quantity
         existeditem?.size=body.size
        if(existeditem!=null  ){
            existeditem.quantity=body.quantity
            existeditem.size=body.size
            if(existeditem.quantity<=0 ){
                product.cartItems.remove(existeditem)
            }else{
                cartRespository.save(existeditem)
            }
        }else if(body.quantity>=1 && product!=null) {
            val cartItem=cartItem(product = product, quantity = body.quantity, size = body.size)
            product.cartItems.add(cartItem)
            cartRespository.save(cartItem)
        }

    }
    @DeleteMapping("/del/{cartId}")  //deleting cart product by id
    fun deleteCart(@PathVariable cartId:Long): ResponseEntity<String> {
       cartService.deleteCartItem(cartId)
        return ResponseEntity.ok("Deleted successfully")
    }
    @PutMapping("/update/{cartId}/add")  //increaing cart product by id
    fun increaseCartItem(@PathVariable cartId: Long, @RequestBody body:addCart){
        return  cartService.updateIncreaseCartitem(cartId,body)
    }
    /*
    @PutMapping("/update/{cartId}/decrease")  //decreasing cart product by id
    fun decreaseCartItem(@PathVariable cartId:Long,@RequestBody body: addCart) {
        return cartService.updateDecreaseCartItem(cartId,body)
    }
     */
    @GetMapping("/item/{cartId}")  //getting cart product by id
    fun getCartItem(@PathVariable cartId:Long): Optional<cartItem> {
        return cartService.getByCartId(cartId)
    }
    @PutMapping("/update/size/{cartId}")  //updating size of cart product
    fun updatingItemSize(@PathVariable cartId: Long,@RequestBody body: addCart): cartItem {
        val updatedproduct= cartService.updateSizeInCart(cartId,body)
        return  updatedproduct
    }
    @GetMapping("/items")  //getting all cart items
    fun getALLItems(): List<cartItem> {
        return cartService.getAllcartproducts()
    }
}








