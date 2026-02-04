package com.copa.api.aluno;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroAluno(
        @NotBlank
        String nome,

        @NotNull
        Long idCasa
) {
}
