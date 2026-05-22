package br.com.fiap.autoescola.dto;

import br.com.fiap.autoescola.entity.Instrutor;
import br.com.fiap.autoescola.enums.Especialidade;

public record InstrutorDetalhesDTO(
        Long id,
        String nome,
        String email,
        String telefone,
        String cnh,
        Especialidade especialidade,
        EnderecoDTO endereco,
        Boolean ativo
) {
    public InstrutorDetalhesDTO(Instrutor instrutor) {
        this(
                instrutor.getId(),
                instrutor.getNome(),
                instrutor.getEmail(),
                instrutor.getTelefone(),
                instrutor.getCnh(),
                instrutor.getEspecialidade(),
                new EnderecoDTO(
                        instrutor.getEndereco().getLogradouro(),
                        instrutor.getEndereco().getNumero(),
                        instrutor.getEndereco().getComplemento(),
                        instrutor.getEndereco().getBairro(),
                        instrutor.getEndereco().getCidade(),
                        instrutor.getEndereco().getUf(),
                        instrutor.getEndereco().getCep()
                ),
                instrutor.getAtivo()
        );
    }
}
