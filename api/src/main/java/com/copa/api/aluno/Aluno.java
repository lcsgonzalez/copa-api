package com.copa.api.aluno;

import com.copa.api.casa.Casa;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

@Table(name="alunos")
@Entity(name="Aluno")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Aluno {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_casa", referencedColumnName="id")
    private Casa casa;
    private boolean ativo;

    public Aluno(@Valid DadosCadastroAluno dados, Casa casa) {
        this.nome = dados.nome();
        this.casa = casa;
        this.ativo = true;
    }

    public void atualizarInformacoes(@Valid DadosAtualizarAluno dados, Casa casa) {
        if(dados.nome() != null){
            this.nome = dados.nome();
        }
        if(casa != null){
            this.casa = casa;
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}