package solutisdevtrail.desafiolocadoraveiculos.model.dto;

import solutisdevtrail.desafiolocadoraveiculos.model.entity.Funcionario;
import solutisdevtrail.desafiolocadoraveiculos.model.entity.Sexo;

import java.util.Date;

public record FuncionarioDTO(Long id, String name, Date dataNascimento, String cpf, Sexo sexo, String matricula, String email) {
    public FuncionarioDTO(Funcionario funcionario) {
        this(funcionario.getId(), funcionario.getName(), funcionario.getDataNascimento(), funcionario.getCpf(), funcionario.getSexo(), funcionario.getMatricula(), funcionario.getEmail());
    }
}
