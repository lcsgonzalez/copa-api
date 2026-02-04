package com.copa.api.controller;

import com.copa.api.aluno.*;
import com.copa.api.casa.Casa;
import com.copa.api.casa.CasaRepository;
import com.copa.api.casa.DadosCadastroCasa;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("alunos")
public class AlunoController {

    @Autowired
    private AlunoRepository repository;

    @Autowired
    private CasaRepository casaRepository;

    @PostMapping
    @Transactional
    public void cadastrarAluno(@RequestBody @Valid DadosCadastroAluno dados){
        Casa casa = casaRepository.getReferenceById(dados.idCasa());
        repository.save(new Aluno(dados, casa));
    }

    @GetMapping
    public Page<DadosListagemAluno> listar(@PageableDefault(size=35, sort={"nome"}) Pageable paginacao){
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemAluno::new);
    }

    @PutMapping("/{id}")
    @Transactional
    public void atualizarAluno(@PathVariable Long id,
                               @RequestBody @Valid DadosAtualizarAluno dados){
        var aluno = repository.getReferenceById(id);
        if(dados.idCasa() != null){
            Casa casa = casaRepository.getReferenceById(dados.idCasa());
            aluno.atualizarInformacoes(dados, casa);
        } else {
            aluno.atualizarInformacoes(dados, null);
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluirAluno(@PathVariable Long id){
        var aluno = repository.getReferenceById(id);
        aluno.excluir();
    }
}
