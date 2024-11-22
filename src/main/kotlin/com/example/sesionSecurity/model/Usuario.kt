package com.example.sesionSecurity.model

import jakarta.persistence.*

@Entity
@Table(name= "usuarios")
class Usuario (
    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Long,
    @Column(unique = true)
    var nombre : String,
    var password: String
)