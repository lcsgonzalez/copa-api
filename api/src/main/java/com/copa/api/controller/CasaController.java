package com.copa.api.controller;

import com.copa.api.casa.Casa;
import com.copa.api.casa.CasaRepository;
import com.copa.api.casa.DadosCadastroCasa;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
