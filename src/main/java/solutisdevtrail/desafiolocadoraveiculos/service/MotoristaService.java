package solutisdevtrail.desafiolocadoraveiculos.service;

import solutisdevtrail.desafiolocadoraveiculos.exception.ResourceNotFoundException;
import solutisdevtrail.desafiolocadoraveiculos.model.dto.MotoristaDTO;
import solutisdevtrail.desafiolocadoraveiculos.model.entity.Motorista;
import solutisdevtrail.desafiolocadoraveiculos.repository.MotoristaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        validarCamposObrigatorios(motoristaDTO);

        Motorista motorista = new Motorista();
        motorista.setName(motoristaDTO.name());
        motorista.setDataNascimento(motoristaDTO.dataNascimento());
        motorista.setCpf(motoristaDTO.cpf());
        motorista.setNumeroCNH(motoristaDTO.numeroCNH());
        motorista.setSexo(motoristaDTO.sexo());

        motorista = motoristaRepository.save(motorista);
        return new MotoristaDTO(motorista);
    }

    public MotoristaDTO update(Long id, MotoristaDTO motoristaDTO) {
        validarCamposObrigatorios(motoristaDTO);

        Motorista motorista = motoristaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Motorista não encontrado com ID: " + id));

        motorista.setName(motoristaDTO.name());
        motorista.setDataNascimento(motoristaDTO.dataNascimento());
        motorista.setCpf(motoristaDTO.cpf());
        motorista.setNumeroCNH(motoristaDTO.numeroCNH());
        motorista.setSexo(motoristaDTO.sexo());

        motorista = motoristaRepository.save(motorista);
        return new MotoristaDTO(motorista);
    }

    public void deleteById(Long id) {
        Motorista motorista = motoristaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Motorista não encontrado com ID: " + id));
        motoristaRepository.deleteById(id);
    }

    private void validarCamposObrigatorios(MotoristaDTO motoristaDTO) {
        if (motoristaDTO.name() == null || motoristaDTO.name().isEmpty() ||
                motoristaDTO.dataNascimento() == null ||
                motoristaDTO.cpf() == null || motoristaDTO.cpf().isEmpty() ||
                motoristaDTO.numeroCNH() == null || motoristaDTO.numeroCNH().isEmpty() ||
                motoristaDTO.sexo() == null) {
            throw new IllegalArgumentException("Todos os campos são obrigatórios.");
        }
    }
}
