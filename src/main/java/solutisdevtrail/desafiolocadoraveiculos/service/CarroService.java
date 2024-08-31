package solutisdevtrail.desafiolocadoraveiculos.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import solutisdevtrail.desafiolocadoraveiculos.exception.ResourceNotFoundException;
import solutisdevtrail.desafiolocadoraveiculos.model.dto.CarroDTO;
import solutisdevtrail.desafiolocadoraveiculos.model.entity.Carro;
import solutisdevtrail.desafiolocadoraveiculos.model.entity.ModeloCarro;
import solutisdevtrail.desafiolocadoraveiculos.repository.CarroRepository;
import solutisdevtrail.desafiolocadoraveiculos.repository.ModeloCarroRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;
    @Autowired
    private ModeloCarroRepository modeloCarroRepository;
    public List<CarroDTO> findAll() {
        return carroRepository.findAll().stream().map(CarroDTO::new).toList();
    }

    public CarroDTO findById(Long id) {
        Carro carro = carroRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Carro não encontrado com ID: " + id));
        return new CarroDTO(carro);
    }

    public CarroDTO save(CarroDTO carroDTO) {
        Carro carro = new Carro();
        ModeloCarro modelo = modeloCarroRepository.findById(carroDTO.modelo_id()).orElseThrow(() -> new ResourceNotFoundException("Modelo não encontrado com ID: " + carroDTO.modelo_id()));
        carro.setCor(carroDTO.cor());
        carro.setChassi(carroDTO.chassi());
        carro.setPlaca( carroDTO.placa());
        carro.setModelo(modelo);
        carro.setValorDiaria(carroDTO.valorDiaria());
        carro.setAcessorios(carroDTO.acessorios());

        carro = carroRepository.save(carro);
        return new CarroDTO(carro);
    }
    public CarroDTO update(Long id, CarroDTO carroDTO) {
        Carro carro = carroRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Carro não encontrado para o ID: " + id));
        ModeloCarro modelo = modeloCarroRepository.findById(carroDTO.modelo_id()).orElseThrow(() -> new ResourceNotFoundException("Modelo não encontrado com ID: " + carroDTO.modelo_id()));
        carro.setChassi(carroDTO.chassi());
        carro.setCor(carroDTO.cor());
        carro.setPlaca(carroDTO.placa());
        carro.setModelo(modelo);
        carro = carroRepository.save(carro);
        return new CarroDTO(carro);
    }

    public void deleteById(Long id) {
        Carro carro = carroRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Carro não encontrado para o ID: " + id));
        carroRepository.deleteById(id);
    }
}
