package solutisdevtrail.desafiolocadoraveiculos.model.dto;

import solutisdevtrail.desafiolocadoraveiculos.model.entity.Motorista;
import solutisdevtrail.desafiolocadoraveiculos.model.entity.Sexo;

import java.util.Date;

public record MotoristaDTO(Long id, String name, Date dataNascimento, String cpf, Sexo sexo, String numeroCNH, String email) {
    public MotoristaDTO(Motorista motorista) {
        this(motorista.getId(), motorista.getName(), motorista.getDataNascimento(), motorista.getCpf(), motorista.getSexo(), motorista.getNumeroCNH(), motorista.getEmail());
    }
}
