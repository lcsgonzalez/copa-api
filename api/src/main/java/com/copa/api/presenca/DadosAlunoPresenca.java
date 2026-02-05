package com.copa.api.presenca;

import jakarta.validation.constraints.NotNull;

public record DadosAlunoPresenca(
        @NotNull
        Long idAluno,

        @NotNull
        Boolean presente
) {
}
