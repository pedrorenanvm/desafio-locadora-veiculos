package solutisdevtrail.desafiolocadoraveiculos.model.dto;

import solutisdevtrail.desafiolocadoraveiculos.model.entity.ModeloCarro;

public record ModeloCarroDTO(Long id, String descricao, String categoria, Long fabricanteId) {
    public ModeloCarroDTO(ModeloCarro modeloCarro) {
        this(modeloCarro.getId(), modeloCarro.getDescricao(),
                modeloCarro.getCategoria().name(), modeloCarro.getFabricante().getId());
    }
}
