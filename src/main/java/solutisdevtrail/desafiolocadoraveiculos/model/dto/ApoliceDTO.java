package solutisdevtrail.desafiolocadoraveiculos.model.dto;

import solutisdevtrail.desafiolocadoraveiculos.model.entity.ApoliceSeguro;

import java.math.BigDecimal;

public record ApoliceDTO(Long id, BigDecimal valorFranquia, boolean protecaoTerceiro,
                         boolean protecaoCausasNaturais, boolean protecaoRoubo) {
    public ApoliceDTO(ApoliceSeguro apoliceSeguro) {
        this(apoliceSeguro.getId(), apoliceSeguro.getValorFranquia(),
                apoliceSeguro.isProtecaoTerceiro(), apoliceSeguro.isProtecaoCausasNaturais(),
                apoliceSeguro.isProtecaoRoubo());
    }
}
