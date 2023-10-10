package com.junocoding.bank.models

import org.springframework.data.relational.core.mapping.Table
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Table("admin")
@Entity
class admin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id:Int=0

    @Column
    var email=""
    @Column
    var password=""
    @Column
    var role="admin"

}