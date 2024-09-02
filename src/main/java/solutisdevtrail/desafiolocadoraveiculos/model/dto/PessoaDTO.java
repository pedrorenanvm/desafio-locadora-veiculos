package solutisdevtrail.desafiolocadoraveiculos.model.dto;

import java.util.Date;

public record PessoaDTO(Long id, String name, Date dataNascimento, String cpf) {
}
