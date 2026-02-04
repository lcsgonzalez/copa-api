package com.copa.api.presenca;

import com.copa.api.aluno.Aluno;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Table(name="presencas")
@Entity(name="Presencas")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Presenca {

    @Id
    private LocalDate data;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_aluno", referencedColumnName="id")
    private Aluno aluno;

}
