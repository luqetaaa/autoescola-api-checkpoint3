package br.com.fiap.autoescola.controller;

import br.com.fiap.autoescola.dto.*;
import br.com.fiap.autoescola.service.AlunoService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoService service;

    public AlunoController(AlunoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<AlunoDetalhesDTO> cadastrar(@RequestBody @Valid AlunoCadastroDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrar(dto));
    }

    @GetMapping
    public ResponseEntity<Page<AlunoListagemDTO>> listar(@RequestParam(defaultValue = "0") int page) {
        return ResponseEntity.ok(service.listar(page));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoDetalhesDTO> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlunoDetalhesDTO> atualizar(@PathVariable Long id, @RequestBody @Valid AlunoAtualizacaoDTO dto) {
        return ResponseEntity.ok(service.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
