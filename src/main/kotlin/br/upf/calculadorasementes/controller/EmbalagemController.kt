package br.upf.calculadorasementes.controller

import br.upf.calculadorasementes.dtos.EmbalagemDTO
import br.upf.calculadorasementes.dtos.EmbalagemResponseDTO
import br.upf.calculadorasementes.service.EmbalagemService
import jakarta.transaction.Transactional
import jakarta.validation.Valid
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/embalagens")
class EmbalagemController(val service: EmbalagemService) {

    @GetMapping
    fun listar(
        @RequestParam(required = false) descricao: String?,
        @PageableDefault(size = 10) paginacao: Pageable
    ): Page<EmbalagemResponseDTO> {
        return service.listar(descricao, paginacao)
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): EmbalagemResponseDTO {
        return service.buscarPorId(id)
    }

    @PostMapping
    @Transactional
    fun cadastrar(@RequestBody @Valid dto: EmbalagemDTO): ResponseEntity<EmbalagemResponseDTO> {
        val embalagemResponse = service.cadastrar(dto)
        return ResponseEntity.status(HttpStatus.CREATED).body(embalagemResponse)
    }

    @PutMapping("/{id}")
    @Transactional
    fun atualizar(@PathVariable id: Long, @RequestBody @Valid dto: EmbalagemDTO): EmbalagemResponseDTO {
        return service.atualizar(id, dto)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    fun deletar(@PathVariable id: Long) {
        service.deletar(id)
    }
}
