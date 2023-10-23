package br.upf.calculadorasementes.repository

import br.upf.calculadorasementes.model.Usuario
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Repository

@Repository
interface UsuarioRepository: JpaRepository<Usuario, Long> {

    fun findByEmail(email: String): UserDetails

}
