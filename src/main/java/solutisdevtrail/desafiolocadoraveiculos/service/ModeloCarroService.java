package solutisdevtrail.desafiolocadoraveiculos.service;

import solutisdevtrail.desafiolocadoraveiculos.exception.ResourceNotFoundException;
import solutisdevtrail.desafiolocadoraveiculos.model.dto.ModeloCarroDTO;
import solutisdevtrail.desafiolocadoraveiculos.model.entity.Categoria;
import solutisdevtrail.desafiolocadoraveiculos.model.entity.Fabricante;
import solutisdevtrail.desafiolocadoraveiculos.model.entity.ModeloCarro;
import solutisdevtrail.desafiolocadoraveiculos.repository.ModeloCarroRepository;
import solutisdevtrail.desafiolocadoraveiculos.repository.FabricanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModeloCarroService {

    @Autowired
    private ModeloCarroRepository modeloCarroRepository;

    @Autowired
    private FabricanteRepository fabricanteRepository;

    public List<ModeloCarroDTO> findAll() {
        return modeloCarroRepository.findAll().stream().map(ModeloCarroDTO::new).toList();
    }

    public ModeloCarroDTO findById(Long id) {
        ModeloCarro modeloCarro = modeloCarroRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Modelo de carro não encontrado com ID: " + id));
        return new ModeloCarroDTO(modeloCarro);
    }

    public ModeloCarroDTO save(ModeloCarroDTO modeloCarroDTO) {
        ModeloCarro modeloCarro = new ModeloCarro();
        modeloCarro.setDescricao(modeloCarroDTO.descricao());
        modeloCarro.setCategoria(Enum.valueOf(Categoria.class, modeloCarroDTO.categoria()));

        Fabricante fabricante = fabricanteRepository.findById(modeloCarroDTO.fabricanteId())
                .orElseThrow(() -> new ResourceNotFoundException("Fabricante não encontrado com ID: " + modeloCarroDTO.fabricanteId()));
        modeloCarro.setFabricante(fabricante);

        modeloCarro = modeloCarroRepository.save(modeloCarro);
        return new ModeloCarroDTO(modeloCarro);
    }

    public ModeloCarroDTO update(Long id, ModeloCarroDTO modeloCarroDTO) {
        ModeloCarro modeloCarro = modeloCarroRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Modelo de carro não encontrado com ID: " + id));

        modeloCarro.setDescricao(modeloCarroDTO.descricao());
        modeloCarro.setCategoria(Enum.valueOf(Categoria.class, modeloCarroDTO.categoria()));

        Fabricante fabricante = fabricanteRepository.findById(modeloCarroDTO.fabricanteId())
                .orElseThrow(() -> new ResourceNotFoundException("Fabricante não encontrado com ID: " + modeloCarroDTO.fabricanteId()));
        modeloCarro.setFabricante(fabricante);

        modeloCarro = modeloCarroRepository.save(modeloCarro);
        return new ModeloCarroDTO(modeloCarro);
    }

    public void deleteById(Long id) {
        ModeloCarro modeloCarro = modeloCarroRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Modelo de carro não encontrado com ID: " + id));
        modeloCarroRepository.deleteById(id);
    }
}
