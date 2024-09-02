package solutisdevtrail.desafiolocadoraveiculos.controller;

import solutisdevtrail.desafiolocadoraveiculos.model.dto.AluguelDTO;
import solutisdevtrail.desafiolocadoraveiculos.service.AluguelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alugueis")
public class AluguelController {

    @Autowired
    private AluguelService aluguelService;

    @GetMapping
    public ResponseEntity<List<AluguelDTO>> findAll() {
        List<AluguelDTO> alugueis = aluguelService.findAll();
        return ResponseEntity.ok(alugueis);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AluguelDTO> findById(@PathVariable Long id) {
        AluguelDTO aluguel = aluguelService.findById(id);
        return ResponseEntity.ok(aluguel);
    }

    @PostMapping
    public ResponseEntity<AluguelDTO> save(@RequestBody AluguelDTO aluguelDTO) {
        AluguelDTO novoAluguel = aluguelService.save(aluguelDTO);
        return new ResponseEntity<>(novoAluguel, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AluguelDTO> update(@PathVariable Long id, @RequestBody AluguelDTO aluguelDTO) {
        AluguelDTO aluguelAtualizado = aluguelService.update(id, aluguelDTO);
        return ResponseEntity.ok(aluguelAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        aluguelService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
