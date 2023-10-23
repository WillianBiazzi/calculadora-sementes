package br.upf.calculadorasementes.dtos

import jakarta.validation.constraints.NotBlank

data class CultivarDTO(
    @field:NotBlank(message = "Cultivar sempre deve ter um nome de registro")
    val nomeRegistro: String,
    val nomeFantasia: String?,
    val pmsMedio: Double?,
    val plantasMetroLinear: Double?
)
