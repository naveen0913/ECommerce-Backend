package com.junocoding.bank.models

import javax.persistence.*
import org.springframework.data.relational.core.mapping.Table
import org.springframework.stereotype.Component
import javax.persistence.GenerationType.AUTO
import javax.persistence.Entity
import javax.persistence.GeneratedValue

@Component
@Table("cart_item")
@Entity
class cartItem(
    @Id
    @GeneratedValue(strategy = AUTO)
    val id: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    val product: Product,

    var quantity: Int=0,
    var size:String=" "
)

