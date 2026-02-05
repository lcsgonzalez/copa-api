package com.copa.api.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroUsuario(
        @NotBlank
        @Email
        String email,

        @NotBlank
        String senha,

        @NotNull
        Long idAluno) {
}
