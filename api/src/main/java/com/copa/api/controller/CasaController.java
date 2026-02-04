package com.copa.api.controller;

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
@RequestMapping("casas")
public class CasaController {

    @Autowired
    private CasaRepository repository;

    @PostMapping
    @Transactional
    public void cadastrarCasa(@RequestBody @Valid DadosCadastroCasa dados){
            repository.save(new Casa(dados));
    }

    @GetMapping
    public Page<Casa> listar(@PageableDefault(size=4, sort={"nome"}) Pageable paginacao){
        return repository.findAllByAtivoTrue(paginacao);
    }

    @PutMapping
    @Transactional
    public void atualizarCasa(@RequestBody @Valid Casa casaAtualizar){
        var casa = repository.getReferenceById(casaAtualizar.getId());
        casa.atualizarInformacoes(casaAtualizar);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluirCasa(@PathVariable Long id){
        var casa = repository.getReferenceById(id);
        casa.excluir();
    }
}
