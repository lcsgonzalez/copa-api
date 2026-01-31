package com.copa.api.presenca;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class IdAlunoData implements Serializable {
    private LocalDate data;
    private Long idAluno;

    private IdAlunoData(){}

    public IdAlunoData(LocalDate data, Long idAluno) {
        this.data = data;
        this.idAluno = idAluno;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IdAlunoData that = (IdAlunoData) o;
        return Objects.equals(data, that.data) && Objects.equals(idAluno, that.idAluno);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, idAluno);
    }
}
