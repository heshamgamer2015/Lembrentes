package com.exercicio_2.demo.Controller;


import com.exercicio_2.demo.Entiny.lembreteEntiny;
import com.exercicio_2.demo.Services.lembreteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/lembrete")
public class lembreteController {
    @Autowired
    private lembreteServices services;


    @GetMapping
    public ResponseEntity<List<lembreteEntiny>> buscarLembretesPorNome(@RequestParam("nome") String nome) {
        try {
            List<lembreteEntiny> lembretes = services.findByName(nome);
            return ResponseEntity.ok(lembretes);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }


    @PostMapping
    public ResponseEntity<lembreteEntiny> createLembrete(@RequestBody lembreteEntiny lembrete){
        try {
            lembreteEntiny novoLembrete = services.save(lembrete);
            return ResponseEntity.status(HttpStatus.CREATED).body(novoLembrete);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

}