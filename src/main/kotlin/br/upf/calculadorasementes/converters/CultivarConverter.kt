package br.upf.calculadorasementes.converters

import br.upf.calculadorasementes.dtos.CultivarDTO
import br.upf.calculadorasementes.dtos.CultivarResponseDTO
import br.upf.calculadorasementes.model.Cultivar
import org.springframework.stereotype.Component

@Component
class CultivarConverter {
    fun toCultivar(dto: CultivarDTO): Cultivar {
        return Cultivar(
            nomeRegistro = dto.nomeRegistro,
            nomeFantasia = dto.nomeFantasia,
            pmsMedio = dto.pmsMedio,
            plantasMetroLinear = dto.plantasMetroLinear
        )
    }

    fun toCultivarResponseDTO(cultivar: Cultivar): CultivarResponseDTO {
        return CultivarResponseDTO(
            id = cultivar.id,
            nomeRegistro = cultivar.nomeRegistro,
            nomeFantasia = cultivar.nomeFantasia,
            pmsMedio = cultivar.pmsMedio,
            plantasMetroLinear = cultivar.plantasMetroLinear
        )
    }
}
