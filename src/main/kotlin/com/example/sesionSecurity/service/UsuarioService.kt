package com.example.sesionSecurity.service

import com.example.sesionSecurity.model.Session
import com.example.sesionSecurity.model.Usuario
import com.example.sesionSecurity.repository.SessionRepository
import com.example.sesionSecurity.repository.usuarioRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.lang.RuntimeException
import java.time.LocalDateTime
import java.util.UUID


@Service
class UsuarioService {

    @Autowired
    private lateinit var usuarioRepository: usuarioRepository
    @Autowired
    private lateinit var sessionRepository: SessionRepository
    fun login(userLogin: Usuario): String {
        //Comprobar credenciales
        //1 obtener user de bd
        val userDB = usuarioRepository.findByNombre(userLogin.nombre).orElseThrow()
        // 2 compruebo nombre y pass
        if (userDB.password == userLogin.password) {
            //3 generar el token
            var token: String = ""
            token = UUID.randomUUID().toString()

            //4 crear una session
            val s:Session= Session(
                null,
                token,
                userDB,
                LocalDateTime.now().plusMinutes(3)
            )
            //5 insertamos en BDD
            sessionRepository.save(s)
            return token
        } else {
            throw RuntimeException("CREDENCIALES INCORRECTAS")
        }
    }
}