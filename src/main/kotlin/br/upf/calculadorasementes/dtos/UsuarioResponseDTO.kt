package br.upf.calculadorasementes.dtos

data class UsuarioResponseDTO(
    val id: Long? = null,
    val nome: String,
    val cidade: String,
    val telefone: String,
    val email: String
)
