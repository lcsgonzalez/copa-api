package com.copa.api.casa;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name="casas")
@Entity(name="Casa")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Casa {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private boolean ativo;

    public Casa(@Valid DadosCadastroCasa dados) {
        this.nome = dados.nome();
        this.ativo = true;
    }

    public void atualizarInformacoes(@Valid Casa casaAtualizar) {
        if(casaAtualizar.getNome()!=null){
            this.nome = casaAtualizar.getNome();
        }
    }

    public void excluir(){
        this.ativo = false;
    }
}
