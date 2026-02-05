package com.copa.api.controller;

import com.copa.api.aluno.AlunoRepository;
import com.copa.api.presenca.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("presencas")
public class PresencaController {

    @Autowired
    private PresencaRepository repository;

    @Autowired
    private AlunoRepository alunoRepository;

    // Registrar presença individual
    @PostMapping
    @Transactional
    public ResponseEntity<DadosListagemPresenca> registrarPresenca(
            @RequestBody @Valid DadosRegistrarPresenca dados,
            UriComponentsBuilder uriBuilder) {
        var aluno = alunoRepository.getReferenceById(dados.idAluno());
        var presenca = new Presenca(dados, aluno);
        repository.save(presenca);

        var uri = uriBuilder.path("/presencas/{data}/{idAluno}")
                .buildAndExpand(presenca.getData(), presenca.getAluno().getId())
                .toUri();
        return ResponseEntity.created(uri).body(new DadosListagemPresenca(presenca));
    }

    // Registrar chamada completa (múltiplos alunos)
    @PostMapping("/chamada")
    @Transactional
    public ResponseEntity<List<DadosListagemPresenca>> registrarChamada(
            @RequestBody @Valid DadosRegistrarChamada dados) {

        var presencas = dados.alunos().stream()
                .map(alunoPresenca -> {
                    var aluno = alunoRepository.getReferenceById(alunoPresenca.idAluno());
                    var dadosPresenca = new DadosRegistrarPresenca(
                            dados.data(),
                            alunoPresenca.idAluno(),
                            alunoPresenca.presente()
                    );
                    return new Presenca(dadosPresenca, aluno);
                })
                .collect(Collectors.toList());

        repository.saveAll(presencas);

        var resultado = presencas.stream()
                .map(DadosListagemPresenca::new)
                .collect(Collectors.toList());

        return ResponseEntity.ok(resultado);
    }

    // Listar presenças por data
    @GetMapping("/data/{data}")
    public Page<DadosListagemPresenca> listarPorData(
            @PathVariable LocalDate data,
            @PageableDefault(size=50, sort={"aluno"}) Pageable paginacao) {
        return repository.findByData(data, paginacao)
                .map(DadosListagemPresenca::new);
    }

    // Listar presenças de um aluno
    @GetMapping("/aluno/{idAluno}")
    public Page<DadosListagemPresenca> listarPorAluno(
            @PathVariable Long idAluno,
            @PageableDefault(size=50, sort={"data"}) Pageable paginacao) {
        return repository.findByAlunoId(idAluno, paginacao)
                .map(DadosListagemPresenca::new);
    }

    // Buscar presença específica
    @GetMapping("/{data}/{idAluno}")
    public ResponseEntity<DadosListagemPresenca> detalhar(
            @PathVariable LocalDate data,
            @PathVariable Long idAluno) {
        var presencaId = new PresencaId(data, idAluno);
        var presenca = repository.getReferenceById(presencaId);
        return ResponseEntity.ok(new DadosListagemPresenca(presenca));
    }

    // Atualizar presença (corrigir chamada)
    @PutMapping("/{data}/{idAluno}")
    @Transactional
    public ResponseEntity<DadosListagemPresenca> atualizarPresenca(
            @PathVariable LocalDate data,
            @PathVariable Long idAluno,
            @RequestBody @Valid DadosAtualizarPresenca dados) {

        var presencaId = new PresencaId(data, idAluno);
        var presenca = repository.getReferenceById(presencaId);
        presenca.atualizarPresenca(dados.presente());

        return ResponseEntity.ok(new DadosListagemPresenca(presenca));
    }

    // Deletar presença
    @DeleteMapping("/{data}/{idAluno}")
    @Transactional
    public ResponseEntity<Void> excluirPresenca(
            @PathVariable LocalDate data,
            @PathVariable Long idAluno) {
        var presencaId = new PresencaId(data, idAluno);
        repository.deleteById(presencaId);
        return ResponseEntity.noContent().build();
    }
}