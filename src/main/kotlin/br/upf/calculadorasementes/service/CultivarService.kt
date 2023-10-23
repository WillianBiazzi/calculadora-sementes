package br.upf.calculadorasementes.service

import br.upf.calculadorasementes.converters.CultivarConverter
import br.upf.calculadorasementes.dtos.CultivarDTO
import br.upf.calculadorasementes.dtos.CultivarResponseDTO
import br.upf.calculadorasementes.exceptions.NotFoundException
import br.upf.calculadorasementes.repository.CultivarRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

private const val CULTIVAR_NOT_FOUND_MESSAGE = "Cultivar não encontrada!"

@Service
class CultivarService(
    private val repository: CultivarRepository,
    private val converter: CultivarConverter
) {

    fun listar(
        nomeCultivar: String?,
        paginacao: Pageable): Page<CultivarResponseDTO> {
        val cultivares = if (nomeCultivar == null) {
            repository.findAll(paginacao)
        } else {
            repository.findByNomeRegistro(nomeCultivar, paginacao)
        }
        return cultivares
            .map(converter::toCultivarResponseDTO)
    }

    fun buscarPorId(id: Long): CultivarResponseDTO {
        val cultivar = repository.findById(id)
            .orElseThrow { NotFoundException(CULTIVAR_NOT_FOUND_MESSAGE) }
        return converter.toCultivarResponseDTO(cultivar)
    }

    fun cadastrar(dto: CultivarDTO): CultivarResponseDTO {
        return converter.toCultivarResponseDTO(
            repository.save(converter.toCultivar(dto))
        )
    }

    fun atualizar(id: Long, dto: CultivarDTO): CultivarResponseDTO {
        val cultivar = repository.findById(id)
            .orElseThrow { NotFoundException(CULTIVAR_NOT_FOUND_MESSAGE) }
            .copy(
                nomeFantasia = dto.nomeFantasia,
                nomeRegistro = dto.nomeRegistro,
                pmsMedio = dto.pmsMedio,
                plantasMetroLinear = dto.plantasMetroLinear
            )
        return converter.toCultivarResponseDTO(repository.save(cultivar))
    }

    fun deletar(id: Long) {
        repository.deleteById(id)
    }
}
