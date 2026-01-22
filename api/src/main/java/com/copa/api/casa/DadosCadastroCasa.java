package com.copa.api.casa;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroCasa(

        @NotBlank
        String nome) {
}
