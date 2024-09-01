package solutisdevtrail.desafiolocadoraveiculos.model.dto;

import solutisdevtrail.desafiolocadoraveiculos.model.entity.Fabricante;

public record FabricanteDTO(Long id, String nome) {
    public FabricanteDTO(Fabricante fabricante) {
        this(fabricante.getId(), fabricante.getNome());
    }
}
