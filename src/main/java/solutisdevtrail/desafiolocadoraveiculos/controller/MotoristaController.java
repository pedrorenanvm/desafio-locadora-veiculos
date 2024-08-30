package solutisdevtrail.desafiolocadoraveiculos.controller;

import solutisdevtrail.desafiolocadoraveiculos.service.MotoristaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/motoristas")
public class MotoristaController {

    @Autowired
    private MotoristaService motoristaService;

    @GetMapping
    public List<Motorista> findAll() {
        return motoristaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Motorista> findById(@PathVariable Long id) {
        Optional<Motorista> motorista = motoristaService.findById(id);
        if (motorista.isPresent()) {
            return ResponseEntity.ok(motorista.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Motorista save(@RequestBody Motorista motorista) {
        return motoristaService.save(motorista);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        motoristaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
