package com.copa.api.aluno;

public record DadosListagemAluno(Long id,
                                 String nome,
                                 String nomeCasa,
                                 Long idCasa) {
    public DadosListagemAluno(Aluno aluno) {
        this(
                aluno.getId(),
                aluno.getNome(),
                aluno.getCasa().getNome(),
                aluno.getCasa().getId()
        );
    }
}
