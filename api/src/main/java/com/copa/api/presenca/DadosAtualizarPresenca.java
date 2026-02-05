package com.copa.api.presenca;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarPresenca(
        @NotNull
        Boolean presente
) {
}
