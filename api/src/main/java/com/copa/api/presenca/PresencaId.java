package com.copa.api.presenca;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class PresencaId implements Serializable {
    private LocalDate data;
    private Long aluno;

    public PresencaId() {}

    public PresencaId(LocalDate data, Long aluno) {
        this.data = data;
        this.aluno = aluno;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PresencaId that = (PresencaId) o;
        return Objects.equals(data, that.data) && Objects.equals(aluno, that.aluno);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, aluno);
    }
}
