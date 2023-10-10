package com.junocoding.bank.models

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class  userOrder(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id:Long?,
    val name:String,
    val email:String
)