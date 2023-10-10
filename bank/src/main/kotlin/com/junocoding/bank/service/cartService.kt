package com.junocoding.bank.service


import com.junocoding.bank.DTOS.addCart
import com.junocoding.bank.models.cartItem
import com.junocoding.bank.repositories.cartRespository
import com.junocoding.bank.repositories.productRepository
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RequestBody
import java.util.*
import javax.persistence.EntityNotFoundException
import kotlin.NoSuchElementException

@Service
class cartService(
    private val cartRepository: cartRespository,
    private val productRepository: productRepository
) {
    //deleting item in cart
    fun deleteCartItem(id: Long) {
        val cart = cartRepository.findById(id)
        if (cart.isPresent) {
            cartRepository.deleteById(id)
        } else {
            throw EntityNotFoundException()
        }
    }
    //increasing item in cart
    fun updateIncreaseCartitem(id:Long,@RequestBody body:addCart){
        val presentItem=cartRepository.findById(id)
            .orElseThrow{NoSuchElementException("Item not found")}
        if (presentItem.quantity>=1){          //if item will be one or more we can increase quantity else we can decrease
            presentItem.quantity=body.quantity++
            cartRepository.save(presentItem)
        }else if(presentItem.quantity==2 || presentItem.quantity>=2){
            presentItem.quantity=body.quantity--
            cartRepository.save(presentItem)
        }
        //cartRepository.save(presentItem)
    }

    //updating size for the product in cart
    fun updateSizeInCart(id: Long,@RequestBody body:addCart):cartItem{
        val presentItem=cartRepository.findById(id)
            .orElseThrow { NoSuchElementException("Item not found") }
        presentItem.size=body.size
        cartRepository.save(presentItem)
        return presentItem
    }
    //get particular cart item
    fun getByCartId(id:Long): Optional<cartItem> {
        return cartRepository.findById(id)
    }
    fun getAllcartproducts(): List<cartItem> {
        return cartRepository.findAll()
    }
}





















