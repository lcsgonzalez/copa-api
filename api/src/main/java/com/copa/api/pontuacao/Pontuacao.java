package com.copa.api.pontuacao;

import com.copa.api.casa.Casa;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Table(name="pontuacoes")
@Entity(name="pontuacoes")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Pontuacao {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private int pontos;
    private LocalDate data;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_casa", referencedColumnName="id")
    private Casa casa;
}
