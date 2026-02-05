package com.copa.api.usuario;

import com.copa.api.aluno.Aluno;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

@Table(name="usuarios")
@Entity(name="Usuario")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Usuario {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String senha;

    @OneToOne
    @JoinColumn(name="id_aluno", referencedColumnName="id")
    private Aluno aluno;
    private boolean ativo;

    public Usuario(@Valid DadosCadastroUsuario dados, Aluno aluno, String senhaCriptografada) {
        this.email = dados.email();
        this.senha = senhaCriptografada;
        this.aluno = aluno;
        this.ativo = true;
    }

    public void atualizarInformacoes(@Valid DadosAtualizarUsuario dados, Aluno aluno, String senhaCriptografada) {
        if(dados.email() != null){
            this.email = dados.email();
        }
        if(dados.senha() != null){
            this.senha = senhaCriptografada;
        }
        if(aluno != null){
            this.aluno = aluno;
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
