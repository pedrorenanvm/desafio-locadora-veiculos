package solutisdevtrail.desafiolocadoraveiculos.controller;

import solutisdevtrail.desafiolocadoraveiculos.model.dto.FabricanteDTO;
import solutisdevtrail.desafiolocadoraveiculos.service.FabricanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fabricantes")
public class FabricanteController {

    @Autowired
    private FabricanteService fabricanteService;

    @GetMapping
    public ResponseEntity<List<FabricanteDTO>> findAll() {
        List<FabricanteDTO> fabricantes = fabricanteService.findAll();
        return ResponseEntity.ok(fabricantes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FabricanteDTO> findById(@PathVariable Long id) {
        FabricanteDTO fabricante = fabricanteService.findById(id);
        return ResponseEntity.ok(fabricante);
    }

    @PostMapping
    public ResponseEntity<FabricanteDTO> save(@RequestBody FabricanteDTO fabricanteDTO) {
        FabricanteDTO novoFabricante = fabricanteService.save(fabricanteDTO);
        return new ResponseEntity<>(novoFabricante, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FabricanteDTO> update(@PathVariable Long id, @RequestBody FabricanteDTO fabricanteDTO) {
        FabricanteDTO fabricanteAtualizado = fabricanteService.update(id, fabricanteDTO);
        return ResponseEntity.ok(fabricanteAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        fabricanteService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
