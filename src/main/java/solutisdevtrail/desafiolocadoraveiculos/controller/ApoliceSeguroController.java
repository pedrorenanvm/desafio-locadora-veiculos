package solutisdevtrail.desafiolocadoraveiculos.controller;

import solutisdevtrail.desafiolocadoraveiculos.model.dto.ApoliceDTO;
import solutisdevtrail.desafiolocadoraveiculos.service.ApoliceSeguroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/apolices")
public class ApoliceSeguroController {

    @Autowired
    private ApoliceSeguroService apoliceSeguroService;

    @GetMapping
    public ResponseEntity<List<ApoliceDTO>> findAll() {
        List<ApoliceDTO> apolices = apoliceSeguroService.findAll();
        return ResponseEntity.ok(apolices);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApoliceDTO> findById(@PathVariable Long id) {
        ApoliceDTO apolice = apoliceSeguroService.findById(id);
        return ResponseEntity.ok(apolice);
    }

    @PostMapping
    public ResponseEntity<ApoliceDTO> save(@RequestBody ApoliceDTO apoliceDTO) {
        ApoliceDTO novaApolice = apoliceSeguroService.save(apoliceDTO);
        return new ResponseEntity<>(novaApolice, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApoliceDTO> update(@PathVariable Long id, @RequestBody ApoliceDTO apoliceDTO) {
        ApoliceDTO apoliceAtualizada = apoliceSeguroService.update(id, apoliceDTO);
        return ResponseEntity.ok(apoliceAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        apoliceSeguroService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
