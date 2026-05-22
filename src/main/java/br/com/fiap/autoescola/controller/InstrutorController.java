package br.com.fiap.autoescola.controller;

import br.com.fiap.autoescola.dto.*;
import br.com.fiap.autoescola.service.InstrutorService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/instrutores")
public class InstrutorController {

    private final InstrutorService service;

    public InstrutorController(InstrutorService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<InstrutorDetalhesDTO> cadastrar(@RequestBody @Valid InstrutorCadastroDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrar(dto));
    }

    @GetMapping
    public ResponseEntity<Page<InstrutorListagemDTO>> listar(@RequestParam(defaultValue = "0") int page) {
        return ResponseEntity.ok(service.listar(page));
    }

    @GetMapping("/{id}")
    public ResponseEntity<InstrutorDetalhesDTO> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<InstrutorDetalhesDTO> atualizar(@PathVariable Long id, @RequestBody @Valid InstrutorAtualizacaoDTO dto) {
        return ResponseEntity.ok(service.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
