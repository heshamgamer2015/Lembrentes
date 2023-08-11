package com.exercicio_2.demo.Services;

import com.exercicio_2.demo.Entiny.lembreteEntiny;
import com.exercicio_2.demo.Repository.lembreteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class lembreteServices {
    @Autowired
    private lembreteRepository repository;

    public List<lembreteEntiny> findByName(String nome){
        return repository.findByPessoaIdNome(nome);
    }
    public List<lembreteEntiny>findAll(){
        return repository.findAll();
    }
    public lembreteEntiny save(lembreteEntiny lembrete){
        return repository.save(lembrete);
    }

}
