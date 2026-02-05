package com.copa.api.usuario;

import jakarta.validation.constraints.Email;

public record DadosAtualizarUsuario(
        @Email
        String email,

        String senha,

        Long idAluno
) {
}
