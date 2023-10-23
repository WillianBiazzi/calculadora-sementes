package br.upf.calculadorasementes.repository

import br.upf.calculadorasementes.model.Cultivar
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CultivarRepository : JpaRepository<Cultivar, Long> {

    fun findByNomeRegistro(nomeCultivar: String, paginacao: Pageable): Page<Cultivar>
}
