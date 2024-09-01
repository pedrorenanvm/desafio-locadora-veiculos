package solutisdevtrail.desafiolocadoraveiculos.model.dto;

import solutisdevtrail.desafiolocadoraveiculos.model.entity.Acessorio;
import solutisdevtrail.desafiolocadoraveiculos.model.entity.Carro;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public record CarroResponseDTO(Long id, String placa, String chassi, String cor, BigDecimal valorDiaria,
                               String especificacoesTecnicas, String descricao,
                               String modeloDescricao, String modeloCategoria,
                               List<String> acessoriosDescricoes) {

    public CarroResponseDTO(Carro carro) {
        this(
                carro.getId(),
                carro.getPlaca(),
                carro.getChassi(),
                carro.getCor(),
                carro.getValorDiaria(),
                carro.getEspecificacoesTecnicas(),
                carro.getDescricao(),
                carro.getModelo().getDescricao(),
                carro.getModelo().getCategoria().name(),
                carro.getAcessorios().stream()
                        .map(Acessorio::getDescricao)
                        .collect(Collectors.toList())
        );
    }
}
