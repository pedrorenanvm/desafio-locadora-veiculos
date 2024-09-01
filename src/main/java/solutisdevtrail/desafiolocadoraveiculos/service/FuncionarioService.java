package solutisdevtrail.desafiolocadoraveiculos.service;

import solutisdevtrail.desafiolocadoraveiculos.exception.ResourceNotFoundException;
import solutisdevtrail.desafiolocadoraveiculos.model.dto.FuncionarioDTO;
import solutisdevtrail.desafiolocadoraveiculos.model.entity.Funcionario;
import solutisdevtrail.desafiolocadoraveiculos.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public FuncionarioDTO cadastrarFuncionario(FuncionarioDTO funcionarioDTO) {
        validarCamposObrigatorios(funcionarioDTO);

        Funcionario funcionario = new Funcionario();
        funcionario.setName(funcionarioDTO.name());
        funcionario.setDataNascimento(funcionarioDTO.dataNascimento());
        funcionario.setCpf(funcionarioDTO.cpf());
        funcionario.setMatricula(funcionarioDTO.matricula());
        funcionario.setSexo(funcionarioDTO.sexo());

        funcionario = funcionarioRepository.save(funcionario);
        return new FuncionarioDTO(funcionario);
    }

    public FuncionarioDTO buscarFuncionarioPorId(Long id) {
        Funcionario funcionario = funcionarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Funcionário não encontrado com ID: " + id));
        return new FuncionarioDTO(funcionario);
    }

    public List<FuncionarioDTO> listarTodosFuncionarios() {
        return funcionarioRepository.findAll().stream().map(FuncionarioDTO::new).toList();
    }

    public FuncionarioDTO atualizarFuncionario(Long id, FuncionarioDTO funcionarioDTO) {
        validarCamposObrigatorios(funcionarioDTO);

        Funcionario funcionario = funcionarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Funcionário não encontrado com ID: " + id));

        funcionario.setName(funcionarioDTO.name());
        funcionario.setDataNascimento(funcionarioDTO.dataNascimento());
        funcionario.setCpf(funcionarioDTO.cpf());
        funcionario.setMatricula(funcionarioDTO.matricula());
        funcionario.setSexo(funcionarioDTO.sexo());

        funcionario = funcionarioRepository.save(funcionario);
        return new FuncionarioDTO(funcionario);
    }

    public void deletarFuncionario(Long id) {
        Funcionario funcionario = funcionarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Funcionário não encontrado com ID: " + id));
        funcionarioRepository.delete(funcionario);
    }

    private void validarCamposObrigatorios(FuncionarioDTO funcionarioDTO) {
        if (funcionarioDTO.name() == null || funcionarioDTO.name().isEmpty() ||
                funcionarioDTO.dataNascimento() == null ||
                funcionarioDTO.cpf() == null || funcionarioDTO.cpf().isEmpty() ||
                funcionarioDTO.matricula() == null || funcionarioDTO.matricula().isEmpty() ||
                funcionarioDTO.sexo() == null) {
            throw new IllegalArgumentException("Todos os campos são obrigatórios.");
        }
    }
}
