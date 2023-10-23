package br.upf.calculadorasementes.repository

import br.upf.calculadorasementes.model.Embalagem
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface EmbalagemRepository : JpaRepository<Embalagem, Long> {

    fun findByDescricao(descricao: String, paginacao: Pageable): Page<Embalagem>
}
