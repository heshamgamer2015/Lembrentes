package com.exercicio_2.demo.Services;


import com.exercicio_2.demo.Entiny.PessoaEntiny;
import com.exercicio_2.demo.Repository.pessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@Service
public class pessoaServices {

    @Autowired
    private pessoaRepository repository;

    public List<PessoaEntiny>findAll(){
        return repository.findAll();
    }
        public PessoaEntiny save(PessoaEntiny pessoa) {
            return repository.save(pessoa);
        }
    public PessoaEntiny editar(Long id, PessoaEntiny novaPessoa) {
        PessoaEntiny pessoaExistente = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pessoa com ID " + id + " não encontrada"));

        pessoaExistente.setNome(novaPessoa.getNome());
        return repository.save(pessoaExistente);
    }
    public void excluirPorId(Long id){
        repository.deleteById(id);
    }
    }




