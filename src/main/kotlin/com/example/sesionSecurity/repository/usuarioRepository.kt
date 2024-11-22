package com.example.sesionSecurity.repository

import com.example.sesionSecurity.model.Usuario
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface usuarioRepository : JpaRepository<Usuario,Long> {
    //DERIVED QUERIES EN JPA
    fun findByNombre(nombre:String): Optional<Usuario>
}