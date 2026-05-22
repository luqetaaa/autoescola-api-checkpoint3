package br.com.fiap.autoescola.dto;

import br.com.fiap.autoescola.enums.Especialidade;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

public record InstrutorCadastroDTO(
        @NotBlank(message = "Nome é obrigatório")
        @Size(max = 120)
        String nome,

        @NotBlank(message = "E-mail é obrigatório")
        @Email(message = "E-mail inválido")
        @Size(max = 120)
        String email,

        @NotBlank(message = "Telefone é obrigatório")
        @Size(max = 20)
        String telefone,

        @NotBlank(message = "CNH é obrigatória")
        @Size(max = 20)
        String cnh,

        @NotNull(message = "Especialidade é obrigatória")
        Especialidade especialidade,

        @NotNull(message = "Endereço é obrigatório")
        @Valid
        EnderecoDTO endereco
) {}
