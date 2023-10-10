package com.junocoding.bank.models

import javax.persistence.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue

@Entity
data class Cart(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = null,
    //@OneToMany(mappedBy = "cart", cascade = [CascadeType.ALL], orphanRemoval = true)
    //val cartItems: MutableList<cartItem> = mutableListOf()
)



