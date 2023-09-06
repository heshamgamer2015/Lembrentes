package com.exercicio_2.demo.Controller;


import com.exercicio_2.demo.Entiny.LembreteEntiny;
import com.exercicio_2.demo.Services.LembreteServices;
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
    private LembreteServices services;


    @GetMapping
    public ResponseEntity<List<LembreteEntiny>> buscarLembretesPorNome(@RequestParam("nome") String nome) {
        try {
            List<LembreteEntiny> lembretes = services.findByName(nome);
            return ResponseEntity.ok(lembretes);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }


    @PostMapping
    public ResponseEntity<LembreteEntiny> createLembrete(@RequestBody LembreteEntiny lembrete){
        try {
            LembreteEntiny novoLembrete = services.cadastrar(lembrete);
            return ResponseEntity.status(HttpStatus.CREATED).body(novoLembrete);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

}