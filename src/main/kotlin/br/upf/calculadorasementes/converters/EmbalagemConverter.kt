package br.upf.calculadorasementes.converters

import br.upf.calculadorasementes.dtos.EmbalagemDTO
import br.upf.calculadorasementes.dtos.EmbalagemResponseDTO
import br.upf.calculadorasementes.model.Embalagem
import org.springframework.stereotype.Component

@Component
class EmbalagemConverter {
    fun toEmbalagem(dto: EmbalagemDTO): Embalagem {
        return Embalagem(
            descricao = dto.descricao,
            numeroSementes = dto.numeroSementes
        )
    }

    fun toEmbalagemResponseDTO(embalagem: Embalagem): EmbalagemResponseDTO {
        return EmbalagemResponseDTO(
            id = embalagem.id,
            descricao = embalagem.descricao,
            numeroSementes = embalagem.numeroSementes
        )
    }
}
