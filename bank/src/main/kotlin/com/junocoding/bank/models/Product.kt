package com.junocoding.bank.models

import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.data.relational.core.mapping.Table
import java.util.Date
import javax.persistence.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType.IDENTITY

@Table("Product")
@Entity
data class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long?=null,
    @Column
    var name: String=" ",
    @Column
    var image1: String=" ",
    @Column
    var image2:String=" ",
    @Column
    var image3:String=" ",
    @Column
    var image4:String=" ",
    @Column
    var offerprice:String=" ",
    @Column
    var price: String=" ",
    @Column
    var stockLevel:String=" ",
    @Column
    var stock: String=" ",
    @Column
    var categoryName: String=" ",
    @Column
    var brandName: String=" ",
    @Column
    var size1:String=" ",
    @Column
    var size2:String=" ",
    @Column
    var size3:String=" ",
    @Column
    var size4:String=" ",
    @Column
    var quantity:Int=0,
    @Column
    var s_quantity:String=" ",
    @Column
    var m_quantity:String=" ",
    @Column
    var l_quantity:String=" ",
    @Column
    var XL_quantity:String=" ",
    @Column
    var XXL_quantity:String=" ",
    @Column(name="date")
    @Temporal(TemporalType.DATE)
    var date:Date?=Date(),

    @OneToMany(mappedBy = "product",cascade = [CascadeType.ALL], orphanRemoval = true)
    @JsonIgnore
    val cartItems:MutableList<cartItem> = mutableListOf(),

    @OneToMany(mappedBy = "product",cascade=[CascadeType.ALL], orphanRemoval = true)
    @JsonIgnore
    val wishListItems:MutableList<wishList> = mutableListOf()

)



