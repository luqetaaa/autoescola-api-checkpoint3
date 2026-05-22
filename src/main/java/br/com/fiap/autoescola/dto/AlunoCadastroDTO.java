package br.com.fiap.autoescola.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record AlunoCadastroDTO(
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

        @NotBlank(message = "CPF é obrigatório")
        @Size(max = 14)
        String cpf,

        @NotNull(message = "Endereço é obrigatório")
        @Valid
        EnderecoDTO endereco
) {}
