package solutisdevtrail.desafiolocadoraveiculos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import solutisdevtrail.desafiolocadoraveiculos.exception.ResourceNotFoundException;
import solutisdevtrail.desafiolocadoraveiculos.model.dto.AcessorioDTO;
import solutisdevtrail.desafiolocadoraveiculos.model.entity.Acessorio;
import solutisdevtrail.desafiolocadoraveiculos.repository.AcessorioRepository;

import java.util.List;

@Service
public class AcessorioService {

    @Autowired
    private AcessorioRepository acessorioRepository;

    public List<AcessorioDTO> findAll() {
        return acessorioRepository.findAll().stream().map(AcessorioDTO::new).toList();
    }

    public AcessorioDTO findById(Long id) {
        Acessorio acessorio = acessorioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Acessório não encontrado com ID: " + id));
        return new AcessorioDTO(acessorio);
    }

    public AcessorioDTO save(AcessorioDTO acessorioDTO) {
        Acessorio acessorio = new Acessorio();
        acessorio.setDescricao(acessorioDTO.descricao());

        acessorio = acessorioRepository.save(acessorio);
        return new AcessorioDTO(acessorio);
    }

    public AcessorioDTO update(Long id, AcessorioDTO acessorioDTO) {
        Acessorio acessorio = acessorioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Acessório não encontrado com ID: " + id));

        acessorio.setDescricao(acessorioDTO.descricao());

        acessorio = acessorioRepository.save(acessorio);
        return new AcessorioDTO(acessorio);
    }

    public void deleteById(Long id) {
        Acessorio acessorio = acessorioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Acessório não encontrado com ID: " + id));
        acessorioRepository.deleteById(id);
    }
}
