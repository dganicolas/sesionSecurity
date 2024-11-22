package com.example.sesionSecurity.controller

import com.example.sesionSecurity.model.Usuario
import com.example.sesionSecurity.service.UsuarioService
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/usuarios")
class UsuarioController {
    @Autowired
    private lateinit var usuarioService: UsuarioService

    @PostMapping("/login")
    fun login(
        @RequestBody usuario: Usuario,
        respuesta: HttpServletResponse
    ): ResponseEntity<Usuario?> {

        //llamamos al service para realizar la logica de negocio
        val token = usuarioService.login(usuario)
        return ResponseEntity(null, HttpStatus.I_AM_A_TEAPOT)
    }
}