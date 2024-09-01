package solutisdevtrail.desafiolocadoraveiculos.controller;

import solutisdevtrail.desafiolocadoraveiculos.model.dto.AcessorioDTO;
import solutisdevtrail.desafiolocadoraveiculos.service.AcessorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/acessorios")
public class AcessorioController {

    @Autowired
    private AcessorioService acessorioService;

    @GetMapping
    public ResponseEntity<List<AcessorioDTO>> findAll() {
        List<AcessorioDTO> acessorios = acessorioService.findAll();
        return ResponseEntity.ok(acessorios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AcessorioDTO> findById(@PathVariable Long id) {
        AcessorioDTO acessorio = acessorioService.findById(id);
        return ResponseEntity.ok(acessorio);
    }

    @PostMapping
    public ResponseEntity<AcessorioDTO> save(@RequestBody AcessorioDTO acessorioDTO) {
        AcessorioDTO novoAcessorio = acessorioService.save(acessorioDTO);
        return new ResponseEntity<>(novoAcessorio, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AcessorioDTO> update(@PathVariable Long id, @RequestBody AcessorioDTO acessorioDTO) {
        AcessorioDTO acessorioAtualizado = acessorioService.update(id, acessorioDTO);
        return ResponseEntity.ok(acessorioAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        acessorioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
