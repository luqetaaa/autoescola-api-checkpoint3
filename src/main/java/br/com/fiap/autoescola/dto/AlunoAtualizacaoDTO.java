package br.com.fiap.autoescola.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record AlunoAtualizacaoDTO(
        @NotBlank(message = "Nome é obrigatório")
        @Size(max = 120)
        String nome,

        @NotBlank(message = "Telefone é obrigatório")
        @Size(max = 20)
        String telefone,

        @NotNull(message = "Endereço é obrigatório")
        @Valid
        EnderecoDTO endereco
) {}
