package com.example.sesionSecurity.repository

import com.example.sesionSecurity.model.Session
import com.example.sesionSecurity.model.Usuario
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface SessionRepository: JpaRepository<Session, Long> {

    fun findByToken(token:String): Optional<Session>
}