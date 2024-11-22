package com.example.sesionSecurity.model

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name= "sessions")
class Session(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,
    var token:String,
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    var usuario: Usuario,
    var fechaExp: LocalDateTime
)