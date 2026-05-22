package br.com.fiap.autoescola.dto;

import br.com.fiap.autoescola.entity.Aluno;

public record AlunoListagemDTO(
        Long id,
        String nome,
        String email,
        String cpf
) {
    public AlunoListagemDTO(Aluno aluno) {
        this(aluno.getId(), aluno.getNome(), aluno.getEmail(), aluno.getCpf());
    }
}
