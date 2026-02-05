package com.copa.api.presenca;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

public record DadosRegistrarChamada(
        @NotNull
        LocalDate data,

        @NotEmpty
        @Valid
        List<DadosAlunoPresenca> alunos
) {
}
