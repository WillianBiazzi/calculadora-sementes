package br.upf.calculadorasementes.controller

import br.upf.calculadorasementes.dtos.LoginDTO
import br.upf.calculadorasementes.dtos.LoginResponseDTO
import br.upf.calculadorasementes.dtos.UsuarioDTO
import br.upf.calculadorasementes.model.Usuario
import br.upf.calculadorasementes.service.TokenService
import br.upf.calculadorasementes.service.UsuarioService
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("auth")
class AuthenticationController(
    val authenticationManager: AuthenticationManager,
    val service: UsuarioService,
    val tokenService: TokenService) {

    @PostMapping("/login")
    fun login(@RequestBody data: LoginDTO): ResponseEntity<LoginResponseDTO> {
        val userPassword = UsernamePasswordAuthenticationToken(
            data.login, data.password)
        val auth = authenticationManager.authenticate(userPassword)
        val token = tokenService.generateToken(auth.principal as Usuario)
        return ResponseEntity.ok(LoginResponseDTO(token))
    }

    @PostMapping("/register")
    fun login(@RequestBody data: UsuarioDTO): ResponseEntity<String> {
        service.cadastrar(data)
        return ResponseEntity.ok().build()
    }
}