package solutisdevtrail.desafiolocadoraveiculos.service;

import solutisdevtrail.desafiolocadoraveiculos.exception.ResourceNotFoundException;
import solutisdevtrail.desafiolocadoraveiculos.model.dto.MotoristaDTO;
import solutisdevtrail.desafiolocadoraveiculos.model.entity.Motorista;
import solutisdevtrail.desafiolocadoraveiculos.repository.MotoristaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MotoristaService {

    @Autowired
    private MotoristaRepository motoristaRepository;

    public List<MotoristaDTO> findAll() {
        return motoristaRepository.findAll().stream().map(MotoristaDTO::new).toList();
    }

    public MotoristaDTO findById(Long id) {
        Motorista motorista = motoristaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Motorista não encontrado com ID: " + id));
        return new MotoristaDTO(motorista);
    }

    public MotoristaDTO save(MotoristaDTO motoristaDTO) {
        Motorista motorista = new Motorista();
        motorista.setName(motoristaDTO.name());
        motorista.setDataNascimento(motoristaDTO.dataNascimento());
        motorista.setCpf(motoristaDTO.cpf());
        motorista.setNumeroCNH(motoristaDTO.numeroCNH());

        motorista = motoristaRepository.save(motorista);
        return new MotoristaDTO(motorista);
    }

    public MotoristaDTO update(Long id, MotoristaDTO motoristaDTO) {
        Motorista motorista = motoristaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Motorista não encontrado com ID: " + id));

        motorista.setName(motoristaDTO.name());
        motorista.setDataNascimento(motoristaDTO.dataNascimento());
        motorista.setCpf(motoristaDTO.cpf());
        motorista.setNumeroCNH(motoristaDTO.numeroCNH());

        motorista = motoristaRepository.save(motorista);
        return new MotoristaDTO(motorista);
    }

    public void deleteById(Long id) {
        Motorista motorista = motoristaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Motorista não encontrado com ID: " + id));
        motoristaRepository.deleteById(id);
    }
}
