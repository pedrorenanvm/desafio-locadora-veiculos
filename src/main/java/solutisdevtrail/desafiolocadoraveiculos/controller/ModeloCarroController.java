package solutisdevtrail.desafiolocadoraveiculos.controller;

import solutisdevtrail.desafiolocadoraveiculos.model.dto.ModeloCarroDTO;
import solutisdevtrail.desafiolocadoraveiculos.service.ModeloCarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/modelos-carro")
public class ModeloCarroController {

    @Autowired
    private ModeloCarroService modeloCarroService;

    @GetMapping
    public ResponseEntity<List<ModeloCarroDTO>> findAll() {
        List<ModeloCarroDTO> modelos = modeloCarroService.findAll();
        return ResponseEntity.ok(modelos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModeloCarroDTO> findById(@PathVariable Long id) {
        ModeloCarroDTO modelo = modeloCarroService.findById(id);
        return ResponseEntity.ok(modelo);
    }

    @PostMapping
    public ResponseEntity<ModeloCarroDTO> save(@RequestBody ModeloCarroDTO modeloCarroDTO) {
        ModeloCarroDTO novoModelo = modeloCarroService.save(modeloCarroDTO);
        return new ResponseEntity<>(novoModelo, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ModeloCarroDTO> update(@PathVariable Long id, @RequestBody ModeloCarroDTO modeloCarroDTO) {
        ModeloCarroDTO modeloAtualizado = modeloCarroService.update(id, modeloCarroDTO);
        return ResponseEntity.ok(modeloAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        modeloCarroService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
