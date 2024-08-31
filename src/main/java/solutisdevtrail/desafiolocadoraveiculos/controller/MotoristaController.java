package solutisdevtrail.desafiolocadoraveiculos.controller;

import solutisdevtrail.desafiolocadoraveiculos.model.dto.MotoristaDTO;
import solutisdevtrail.desafiolocadoraveiculos.service.MotoristaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/motoristas")
public class MotoristaController {

    @Autowired
    private MotoristaService motoristaService;

    @GetMapping
    public ResponseEntity<List<MotoristaDTO>> findAll() {
        List<MotoristaDTO> motoristas = motoristaService.findAll();
        return ResponseEntity.ok(motoristas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MotoristaDTO> findById(@PathVariable Long id) {
        MotoristaDTO motorista = motoristaService.findById(id);
        return ResponseEntity.ok(motorista);
    }

    @PostMapping
    public ResponseEntity<MotoristaDTO> save(@RequestBody MotoristaDTO motoristaDTO) {
        MotoristaDTO novoMotorista = motoristaService.save(motoristaDTO);
        return new ResponseEntity<>(novoMotorista, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MotoristaDTO> update(@PathVariable Long id, @RequestBody MotoristaDTO motoristaDTO) {
        MotoristaDTO motoristaAtualizado = motoristaService.update(id, motoristaDTO);
        return ResponseEntity.ok(motoristaAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        motoristaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
