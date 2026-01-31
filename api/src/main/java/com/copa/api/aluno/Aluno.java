package com.copa.api.aluno;

import com.copa.api.casa.Casa;
import jakarta.persistence.*;
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

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_casa", referencedColumnName="id")
    private Casa casa;
}