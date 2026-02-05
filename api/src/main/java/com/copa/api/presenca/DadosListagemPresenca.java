package com.copa.api.presenca;

import java.time.LocalDate;

public record DadosListagemPresenca(
        LocalDate data,
        Long idAluno,
        String nomeAluno,
        String nomeCasa,
        boolean presente
) {
    public DadosListagemPresenca(Presenca presenca) {
        this(
                presenca.getData(),
                presenca.getAluno().getId(),
                presenca.getAluno().getNome(),
                presenca.getAluno().getCasa().getNome(),
                presenca.isPresente()
        );
    }
}
