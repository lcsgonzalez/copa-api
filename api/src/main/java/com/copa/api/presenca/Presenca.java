package com.copa.api.presenca;

import com.copa.api.aluno.Aluno;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Table(name="presencas")
@Entity(name="Presenca")
@IdClass(PresencaId.class)
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of={"data", "aluno"})
public class Presenca {

    @Id
    private LocalDate data;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_aluno", referencedColumnName="id")
    private Aluno aluno;

    private boolean presente;

    public Presenca(@Valid DadosRegistrarPresenca dados, Aluno aluno) {
        this.data = dados.data();
        this.aluno = aluno;
        this.presente = dados.presente();
    }

    public void atualizarPresenca(boolean presente) {
        this.presente = presente;
    }
}
