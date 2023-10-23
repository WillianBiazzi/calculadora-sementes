package br.upf.calculadorasementes.dtos

data class CultivarResponseDTO (
    val id: Long? = null,
    val nomeFantasia: String?,
    val nomeRegistro: String,
    val pmsMedio: Double?,
    val plantasMetroLinear: Double?
)