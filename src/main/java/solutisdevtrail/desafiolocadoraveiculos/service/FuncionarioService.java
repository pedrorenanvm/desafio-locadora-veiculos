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
        verificarDuplicidade(funcionarioDTO);

        Funcionario funcionario = new Funcionario();
        funcionario.setName(funcionarioDTO.name());
        funcionario.setDataNascimento(funcionarioDTO.dataNascimento());
        funcionario.setCpf(funcionarioDTO.cpf());
        funcionario.setMatricula(funcionarioDTO.matricula());
        funcionario.setSexo(funcionarioDTO.sexo());
        funcionario.setEmail(funcionarioDTO.email());

        funcionario = funcionarioRepository.save(funcionario);
        return new FuncionarioDTO(funcionario); // Retorna o DTO do funcionário criado
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

        // Verifica se o CPF, matrícula ou email já estão em uso por outro funcionário
        if (!funcionario.getCpf().equals(funcionarioDTO.cpf())) {
            funcionarioRepository.findByCpf(funcionarioDTO.cpf()).ifPresent(f -> {
                throw new IllegalArgumentException("CPF já cadastrado para outro funcionário.");
            });
        }

        if (!funcionario.getMatricula().equals(funcionarioDTO.matricula())) {
            funcionarioRepository.findByMatricula(funcionarioDTO.matricula()).ifPresent(f -> {
                throw new IllegalArgumentException("Matrícula já cadastrada para outro funcionário.");
            });
        }

        if (!funcionario.getEmail().equals(funcionarioDTO.email())) {
            funcionarioRepository.findByEmail(funcionarioDTO.email()).ifPresent(f -> {
                throw new IllegalArgumentException("Email já cadastrado para outro funcionário.");
            });
        }

        funcionario.setName(funcionarioDTO.name());
        funcionario.setDataNascimento(funcionarioDTO.dataNascimento());
        funcionario.setCpf(funcionarioDTO.cpf());
        funcionario.setMatricula(funcionarioDTO.matricula());
        funcionario.setSexo(funcionarioDTO.sexo());
        funcionario.setEmail(funcionarioDTO.email());

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
                funcionarioDTO.email() == null || funcionarioDTO.email().isEmpty() ||
                funcionarioDTO.sexo() == null) {
            throw new IllegalArgumentException("Todos os campos são obrigatórios.");
        }
    }

    private void verificarDuplicidade(FuncionarioDTO funcionarioDTO) {
        funcionarioRepository.findByCpf(funcionarioDTO.cpf()).ifPresent(f -> {
            throw new IllegalArgumentException("CPF já cadastrado para outro funcionário.");
        });

        funcionarioRepository.findByMatricula(funcionarioDTO.matricula()).ifPresent(f -> {
            throw new IllegalArgumentException("Matrícula já cadastrada para outro funcionário.");
        });

        funcionarioRepository.findByEmail(funcionarioDTO.email()).ifPresent(f -> {
            throw new IllegalArgumentException("Email já cadastrado para outro funcionário.");
        });
    }
}
