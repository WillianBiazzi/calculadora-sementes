package br.upf.calculadorasementes.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class Cultivar(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val nomeFantasia: String?,
    val nomeRegistro: String,
    val pmsMedio: Double?,
    val plantasMetroLinear: Double?
)
