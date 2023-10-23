package br.upf.calculadorasementes.service

import br.upf.calculadorasementes.converters.EmbalagemConverter
import br.upf.calculadorasementes.dtos.EmbalagemDTO
import br.upf.calculadorasementes.dtos.EmbalagemResponseDTO
import br.upf.calculadorasementes.exceptions.NotFoundException
import br.upf.calculadorasementes.repository.EmbalagemRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

private const val EMBALAGEM_NOT_FOUND_MESSAGE = "Embalagem não encontrada!"

@Service
class EmbalagemService(
    private val repository: EmbalagemRepository,
    private val converter: EmbalagemConverter
) {

    fun listar(
        descricao: String?,
        paginacao: Pageable
    ): Page<EmbalagemResponseDTO> {
        val embalagens = if (descricao == null) {
            repository.findAll(paginacao)
        } else {
            repository.findByDescricao(descricao, paginacao)
        }
        return embalagens
            .map(converter::toEmbalagemResponseDTO)
    }

    fun buscarPorId(id: Long): EmbalagemResponseDTO {
        val embalagem = repository.findById(id)
            .orElseThrow { NotFoundException(EMBALAGEM_NOT_FOUND_MESSAGE) }
        return converter.toEmbalagemResponseDTO(embalagem)
    }

    fun cadastrar(dto: EmbalagemDTO): EmbalagemResponseDTO {
        return converter.toEmbalagemResponseDTO(
            repository.save(converter.toEmbalagem(dto))
        )
    }

    fun atualizar(id: Long, dto: EmbalagemDTO): EmbalagemResponseDTO {
        val embalagem = repository.findById(id)
            .orElseThrow { NotFoundException(EMBALAGEM_NOT_FOUND_MESSAGE) }
            .copy(
                descricao = dto.descricao,
                numeroSementes = dto.numeroSementes
            )
        return converter.toEmbalagemResponseDTO(repository.save(embalagem))
    }

    fun deletar(id: Long) {
        repository.deleteById(id)
    }
}
