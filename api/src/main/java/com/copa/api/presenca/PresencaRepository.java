package com.copa.api.presenca;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface PresencaRepository extends JpaRepository<Presenca, PresencaId> {

    @Query("SELECT p FROM Presenca p WHERE p.data = :data")
    Page<Presenca> findByData(@Param("data") LocalDate data, Pageable paginacao);

    @Query("SELECT p FROM Presenca p WHERE p.aluno.id = :idAluno")
    Page<Presenca> findByAlunoId(@Param("idAluno") Long idAluno, Pageable paginacao);

    @Query("SELECT p FROM Presenca p WHERE p.data BETWEEN :dataInicio AND :dataFim")
    List<Presenca> findByDataBetween(
            @Param("dataInicio") LocalDate dataInicio,
            @Param("dataFim") LocalDate dataFim
    );
}
