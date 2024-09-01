package solutisdevtrail.desafiolocadoraveiculos.service;

import solutisdevtrail.desafiolocadoraveiculos.exception.ResourceNotFoundException;
import solutisdevtrail.desafiolocadoraveiculos.model.dto.FabricanteDTO;
import solutisdevtrail.desafiolocadoraveiculos.model.entity.Fabricante;
import solutisdevtrail.desafiolocadoraveiculos.repository.FabricanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FabricanteService {

    @Autowired
    private FabricanteRepository fabricanteRepository;

    public List<FabricanteDTO> findAll() {
        return fabricanteRepository.findAll().stream().map(FabricanteDTO::new).toList();
    }

    public FabricanteDTO findById(Long id) {
        Fabricante fabricante = fabricanteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Fabricante não encontrado com ID: " + id));
        return new FabricanteDTO(fabricante);
    }

    public FabricanteDTO save(FabricanteDTO fabricanteDTO) {
        Fabricante fabricante = new Fabricante();
        fabricante.setNome(fabricanteDTO.nome());

        fabricante = fabricanteRepository.save(fabricante);
        return new FabricanteDTO(fabricante);
    }

    public FabricanteDTO update(Long id, FabricanteDTO fabricanteDTO) {
        Fabricante fabricante = fabricanteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Fabricante não encontrado com ID: " + id));

        fabricante.setNome(fabricanteDTO.nome());

        fabricante = fabricanteRepository.save(fabricante);
        return new FabricanteDTO(fabricante);
    }

    public void deleteById(Long id) {
        Fabricante fabricante = fabricanteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Fabricante não encontrado com ID: " + id));
        fabricanteRepository.deleteById(id);
    }
}
