    package com.exercicio_2.demo.Controller;

    import com.exercicio_2.demo.Services.pessoaServices;
    import com.exercicio_2.demo.Entiny.PessoaEntiny;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;
    import org.springframework.web.server.ResponseStatusException;

    import java.util.List;

    @RestController
    @RequestMapping("/pessoa")
    public class pessoaController {
        @Autowired
        private pessoaServices services;

        @GetMapping
        public ResponseEntity<List<PessoaEntiny>> findAll(){
            try {
                return ResponseEntity.ok(services.findAll());
            }catch (Exception e){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
            }
        }
        @PostMapping
        public ResponseEntity<PessoaEntiny> createPessoa(@RequestBody PessoaEntiny pessoa) {
            try {
                PessoaEntiny novaPessoa = services.save(pessoa);
                return ResponseEntity.status(HttpStatus.CREATED).body(novaPessoa);
            } catch (Exception e) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
            }
        }
        @PutMapping("/{id}")
        public ResponseEntity<PessoaEntiny> editar(@PathVariable Long id, @RequestBody PessoaEntiny pessoa){

            try {
                PessoaEntiny pessoaAtualizada = services.editar(id , pessoa);
                return ResponseEntity.ok(pessoaAtualizada);

            }catch (Exception e){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
            }

        }
        @DeleteMapping("/{id}")
        public ResponseEntity<String> deleteById(@PathVariable Long id){
            try {
                services.excluirPorId(id);
                return ResponseEntity.ok("Pessoa com ID " + id + " excluída com sucesso.");
            }catch (Exception e){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
            }
        }

    }



