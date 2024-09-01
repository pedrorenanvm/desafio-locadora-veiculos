package solutisdevtrail.desafiolocadoraveiculos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import solutisdevtrail.desafiolocadoraveiculos.model.dto.CarroDTO;
import solutisdevtrail.desafiolocadoraveiculos.model.entity.Carro;
import solutisdevtrail.desafiolocadoraveiculos.service.CarroService;

import java.util.List;

@RestController
@RequestMapping("/api/carros")
public class CarroController {

    @Autowired
    private CarroService carroService;

    @GetMapping
    public ResponseEntity<List<CarroDTO>>findAll(){
       List<CarroDTO> carros = carroService.findAll();
       return ResponseEntity.ok(carros);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CarroDTO> findById(@PathVariable long id){
        CarroDTO carro = carroService.findById(id);
        return ResponseEntity.ok(carro);
    }
    @PostMapping
    public ResponseEntity<CarroDTO> create(@RequestBody CarroDTO carro){
        CarroDTO carroDTO = carroService.save(carro);
        return ResponseEntity.status(HttpStatus.CREATED).body(carroDTO);
    }
    @PutMapping("/{id}")
    public ResponseEntity<CarroDTO> update(@PathVariable long id, @RequestBody CarroDTO carroDTO){
        CarroDTO carro = carroService.update(id,carroDTO);
        return ResponseEntity.ok(carro);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<CarroDTO> delete(@PathVariable long id){
        carroService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
















}
