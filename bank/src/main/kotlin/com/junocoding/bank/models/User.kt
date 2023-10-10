package com.junocoding.bank.models


import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDate
import javax.persistence.*

@Table("user")
@Entity
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id:Long=0
    @Column
    var name=""
    @Column(unique = true)
    var email=""
    @Column
    var password=""
    @Column
    var date=LocalDate.now()
}