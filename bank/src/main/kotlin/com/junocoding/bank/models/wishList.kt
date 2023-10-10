package com.junocoding.bank.models

import javax.persistence.*

@Entity
data class wishList(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id:Long?=null,
    //@ManyToMany
    //val products:MutableList<Product> = mutableListOf(),

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    val product: Product,
    val userId: Long,
)