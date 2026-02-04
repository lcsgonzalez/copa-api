package com.copa.api.aluno;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarAluno(
        String nome,
        Long idCasa
) {
}
