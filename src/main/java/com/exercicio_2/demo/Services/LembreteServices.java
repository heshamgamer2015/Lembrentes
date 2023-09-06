package com.exercicio_2.demo.Services;

import com.exercicio_2.demo.Entiny.LembreteEntiny;
import com.exercicio_2.demo.Repository.LembreteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LembreteServices {
    @Autowired
    private LembreteRepository repository;

    public List<LembreteEntiny> findByName(String nome){
        return repository.findByPessoaIdNome(nome);
    }
    public List<LembreteEntiny>findAll(){
        return repository.findAll();
    }
    public LembreteEntiny cadastrar(LembreteEntiny lembrete){
        return repository.save(lembrete);
    }

}
