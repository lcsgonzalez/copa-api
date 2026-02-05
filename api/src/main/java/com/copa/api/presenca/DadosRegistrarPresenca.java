package com.copa.api.presenca;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public record DadosRegistrarPresenca(
        @NotNull
        LocalDate data,

        @NotNull
        Long idAluno,

        @NotNull
        Boolean presente
) {
}
