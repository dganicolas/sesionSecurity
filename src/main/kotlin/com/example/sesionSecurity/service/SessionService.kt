package com.example.sesionSecurity.service

import com.example.sesionSecurity.repository.SessionRepository
import com.example.sesionSecurity.repository.usuarioRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class SessionService {

    @Autowired
    private lateinit var sessionRepository: SessionRepository

    fun checkToken(): Boolean{
        return true
    }
}