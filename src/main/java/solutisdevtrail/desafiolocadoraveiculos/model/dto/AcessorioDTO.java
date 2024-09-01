package solutisdevtrail.desafiolocadoraveiculos.model.dto;

import solutisdevtrail.desafiolocadoraveiculos.model.entity.Acessorio;

public record AcessorioDTO(Long id, String descricao) {

    public AcessorioDTO(Acessorio acessorio) {
        this(acessorio.getId(), acessorio.getDescricao());
    }
}
