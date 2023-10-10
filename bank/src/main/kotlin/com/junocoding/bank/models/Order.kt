package com.junocoding.bank.models


import java.time.LocalDate
import java.time.LocalTime
import javax.persistence.*

@Entity
@Table(name = "customer_order")
class Order (

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null,

    @Column
    var address:String="",
    @Column
    var name:String="",
    @Column
    var phone:String="",
    @Column
    var quantity :Int,
    @Column
    var size:String=" ",

    val productName: String = "",
    var orderedDate: LocalDate = LocalDate.now(),
    var orderedTime: LocalTime = LocalTime.now(),
    var status: String = "",
    var totalPrice: String = "",
    var brandName: String = "",
    var payment: String = "",
    var category: String = " ",

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_Id")
    var product: Product,
    var userId: Long
    /*
@OneToMany(mappedBy = "order", cascade = [CascadeType.ALL])
val orderItems:List<OrderItem> = emptyList(),
 */
)



