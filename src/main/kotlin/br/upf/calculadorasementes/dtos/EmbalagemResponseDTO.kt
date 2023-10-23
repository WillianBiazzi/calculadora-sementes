package br.upf.calculadorasementes.dtos

data class EmbalagemResponseDTO (
    val id: Long? = null,
    val descricao: String,
    val numeroSementes: Int
)
