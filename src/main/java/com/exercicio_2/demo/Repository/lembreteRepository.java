package com.exercicio_2.demo.Repository;

import com.exercicio_2.demo.Entiny.lembreteEntiny;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface lembreteRepository extends JpaRepository<lembreteEntiny,Long> {
    List<lembreteEntiny> findByPessoaIdNome(String nome);

}
