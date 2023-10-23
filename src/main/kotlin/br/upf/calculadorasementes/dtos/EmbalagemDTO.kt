package br.upf.calculadorasementes.dtos

import jakarta.validation.constraints.NotBlank

data class EmbalagemDTO(
    @field:NotBlank(message = "A descrição da embalagem é obrigatória")
    val descricao: String,
    val numeroSementes: Int
)
