package com.copa.api.usuario;

public record DadosListagemUsuario(
        Long id,
        String email,
        String nomeAluno,
        Long idAluno
) {
    public DadosListagemUsuario(Usuario usuario) {
        this(
                usuario.getId(),
                usuario.getEmail(),
                usuario.getAluno().getNome(),
                usuario.getAluno().getId()
        );
    }
}
