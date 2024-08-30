package solutisdevtrail.desafiolocadoraveiculos.model.dto;


import solutisdevtrail.desafiolocadoraveiculos.model.entity.Motorista;

import java.util.Date;

public record MotoristaDTO(Long id, String name, Date dataNascimento, String cpf, String numeroCNH) {
    public MotoristaDTO(Motorista motorista) {
        this(motorista.getId(), motorista.getName(), motorista.getDataNascimento(), motorista.getCpf(), motorista.getNumeroCNH());
    }
}
