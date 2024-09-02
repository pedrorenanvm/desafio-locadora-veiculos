package solutisdevtrail.desafiolocadoraveiculos.model.dto;

import solutisdevtrail.desafiolocadoraveiculos.model.entity.Carro;

import java.math.BigDecimal;
import java.util.List;

public record CarroDTO(Long id, String placa, String chassi, String cor, BigDecimal valorDiaria,
                       String especificacoesTecnicas, String descricao, Long modelo_id, List<Long> acessoriosIds) {

    public CarroDTO(Carro carro) {
        this(carro.getId(), carro.getPlaca(), carro.getChassi(), carro.getCor(), carro.getValorDiaria(),
                carro.getEspecificacoesTecnicas(), carro.getDescricao(),
                carro.getModelo().getId(),
                carro.getAcessorios().stream().map(acessorio -> acessorio.getId()).toList());
    }
}
