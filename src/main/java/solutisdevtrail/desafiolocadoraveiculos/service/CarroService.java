package solutisdevtrail.desafiolocadoraveiculos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import solutisdevtrail.desafiolocadoraveiculos.exception.ResourceNotFoundException;
import solutisdevtrail.desafiolocadoraveiculos.model.dto.CarroDTO;
import solutisdevtrail.desafiolocadoraveiculos.model.entity.Carro;
import solutisdevtrail.desafiolocadoraveiculos.model.entity.ModeloCarro;
import solutisdevtrail.desafiolocadoraveiculos.model.entity.Acessorio;
import solutisdevtrail.desafiolocadoraveiculos.repository.CarroRepository;
import solutisdevtrail.desafiolocadoraveiculos.repository.ModeloCarroRepository;
import solutisdevtrail.desafiolocadoraveiculos.repository.AcessorioRepository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;

    @Autowired
    private ModeloCarroRepository modeloCarroRepository;

    @Autowired
    private AcessorioRepository acessorioRepository;

    public List<CarroDTO> findAll() {
        return carroRepository.findAll().stream().map(CarroDTO::new).toList();
    }

    public CarroDTO findById(Long id) {
        Carro carro = carroRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Carro não encontrado com ID: " + id));
        return new CarroDTO(carro);
    }

    public CarroDTO save(CarroDTO carroDTO) {
        verificarDuplicidade(carroDTO);

        Carro carro = new Carro();
        ModeloCarro modelo = modeloCarroRepository.findById(carroDTO.modelo_id())
                .orElseThrow(() -> new ResourceNotFoundException("Modelo não encontrado com ID: " + carroDTO.modelo_id()));

        Set<Acessorio> acessorios = acessorioRepository.findAllById(carroDTO.acessoriosIds()).stream().collect(Collectors.toSet());

        carro.setCor(carroDTO.cor());
        carro.setChassi(carroDTO.chassi());
        carro.setPlaca(carroDTO.placa());
        carro.setModelo(modelo);
        carro.setValorDiaria(carroDTO.valorDiaria());
        carro.setAcessorios(acessorios);

        carro = carroRepository.save(carro);
        return new CarroDTO(carro);
    }

    public CarroDTO update(Long id, CarroDTO carroDTO) {
        Carro carro = carroRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Carro não encontrado para o ID: " + id));

        // Verifica se o chassi ou a placa já estão em uso por outro carro
        if (!carro.getChassi().equals(carroDTO.chassi())) {
            carroRepository.findByChassi(carroDTO.chassi()).ifPresent(c -> {
                throw new IllegalArgumentException("Chassi já cadastrado para outro carro.");
            });
        }

        if (!carro.getPlaca().equals(carroDTO.placa())) {
            carroRepository.findByPlaca(carroDTO.placa()).ifPresent(c -> {
                throw new IllegalArgumentException("Placa já cadastrada para outro carro.");
            });
        }

        ModeloCarro modelo = modeloCarroRepository.findById(carroDTO.modelo_id())
                .orElseThrow(() -> new ResourceNotFoundException("Modelo não encontrado com ID: " + carroDTO.modelo_id()));

        Set<Acessorio> acessorios = acessorioRepository.findAllById(carroDTO.acessoriosIds()).stream().collect(Collectors.toSet());

        carro.setChassi(carroDTO.chassi());
        carro.setCor(carroDTO.cor());
        carro.setPlaca(carroDTO.placa());
        carro.setModelo(modelo);
        carro.setValorDiaria(carroDTO.valorDiaria());
        carro.setAcessorios(acessorios);

        carro = carroRepository.save(carro);
        return new CarroDTO(carro);
    }

    public void deleteById(Long id) {
        Carro carro = carroRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Carro não encontrado para o ID: " + id));
        carroRepository.deleteById(id);
    }

    private void verificarDuplicidade(CarroDTO carroDTO) {
        carroRepository.findByChassi(carroDTO.chassi()).ifPresent(c -> {
            throw new IllegalArgumentException("Chassi já cadastrado para outro carro.");
        });

        carroRepository.findByPlaca(carroDTO.placa()).ifPresent(c -> {
            throw new IllegalArgumentException("Placa já cadastrada para outro carro.");
        });
    }
}
