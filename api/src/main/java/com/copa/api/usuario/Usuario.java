package com.copa.api.usuario;

import com.copa.api.aluno.Aluno;
import jakarta.persistence.*;
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
}
