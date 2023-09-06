package com.exercicio_2.demo.Repository;

import com.exercicio_2.demo.Entiny.LembreteEntiny;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LembreteRepository extends JpaRepository<LembreteEntiny,Long> {
    List<LembreteEntiny> findByPessoaIdNome(String nome);
    List<LembreteEntiny>findAll(String nome);

}
