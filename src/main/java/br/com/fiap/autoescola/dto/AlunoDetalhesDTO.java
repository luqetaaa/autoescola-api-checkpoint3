package br.com.fiap.autoescola.dto;

import br.com.fiap.autoescola.entity.Aluno;

public record AlunoDetalhesDTO(
        Long id,
        String nome,
        String email,
        String telefone,
        String cpf,
        EnderecoDTO endereco,
        Boolean ativo
) {
    public AlunoDetalhesDTO(Aluno aluno) {
        this(
                aluno.getId(),
                aluno.getNome(),
                aluno.getEmail(),
                aluno.getTelefone(),
                aluno.getCpf(),
                new EnderecoDTO(
                        aluno.getEndereco().getLogradouro(),
                        aluno.getEndereco().getNumero(),
                        aluno.getEndereco().getComplemento(),
                        aluno.getEndereco().getBairro(),
                        aluno.getEndereco().getCidade(),
                        aluno.getEndereco().getUf(),
                        aluno.getEndereco().getCep()
                ),
                aluno.getAtivo()
        );
    }
}
