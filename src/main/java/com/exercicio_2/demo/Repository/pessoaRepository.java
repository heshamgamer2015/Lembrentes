package com.exercicio_2.demo.Repository;

import com.exercicio_2.demo.Entiny.PessoaEntiny;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface pessoaRepository extends JpaRepository<PessoaEntiny, Long> {

}
