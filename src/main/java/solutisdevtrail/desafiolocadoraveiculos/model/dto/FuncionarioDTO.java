package solutisdevtrail.desafiolocadoraveiculos.model.dto;

import solutisdevtrail.desafiolocadoraveiculos.model.entity.Funcionario;

import java.util.Date;

public record FuncionarioDTO(Long id, String name, Date dataNascimento, String cpf, String matricula) {
    public FuncionarioDTO(Funcionario funcionario) {
        this(funcionario.getId(), funcionario.getName(), funcionario.getDataNascimento(), funcionario.getCpf(), funcionario.getMatricula());
    }
}
