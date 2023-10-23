package br.upf.calculadorasementes.controller

import br.upf.calculadorasementes.dtos.CultivarDTO
import br.upf.calculadorasementes.dtos.CultivarResponseDTO
import br.upf.calculadorasementes.service.CultivarService
import jakarta.transaction.Transactional
import jakarta.validation.Valid
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/cultivares")
class CultivarController(val service: CultivarService) {

    @GetMapping
    fun listar(
        @RequestParam(required = false) nomeRegistro: String?,
        @PageableDefault(size = 10) paginacao: Pageable
    ): Page<CultivarResponseDTO> {
        return service.listar(nomeRegistro, paginacao)
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): CultivarResponseDTO {
        return service.buscarPorId(id)
    }

    @PostMapping
    @Transactional
    fun cadastrar(@RequestBody @Valid dto: CultivarDTO): ResponseEntity<CultivarResponseDTO> {
        val cultivarResponse = service.cadastrar(dto)
        return ResponseEntity.status(HttpStatus.CREATED).body(cultivarResponse)
    }

    @PutMapping("/{id}")
    @Transactional
    fun atualizar(@PathVariable id: Long, @RequestBody @Valid dto: CultivarDTO): CultivarResponseDTO {
        return service.atualizar(id, dto)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    fun deletar(@PathVariable id: Long) {
        service.deletar(id)
    }
}
