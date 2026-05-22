package br.com.fiap.autoescola.dto;

import br.com.fiap.autoescola.entity.Instrutor;
import br.com.fiap.autoescola.enums.Especialidade;

public record InstrutorListagemDTO(
        Long id,
        String nome,
        String email,
        String cnh,
        Especialidade especialidade
) {
    public InstrutorListagemDTO(Instrutor instrutor) {
        this(instrutor.getId(), instrutor.getNome(), instrutor.getEmail(), instrutor.getCnh(), instrutor.getEspecialidade());
    }
}
