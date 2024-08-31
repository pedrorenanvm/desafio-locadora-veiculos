package solutisdevtrail.desafiolocadoraveiculos.model.dto;

import solutisdevtrail.desafiolocadoraveiculos.model.entity.Acessorio;
import solutisdevtrail.desafiolocadoraveiculos.model.entity.Carro;

import java.math.BigDecimal;
import java.util.List;

public record CarroDTO(String placa, String chassi, String cor, BigDecimal valorDiaria , Long modelo_id ,
                       List<Acessorio> acessorios) {
    public CarroDTO(Carro carro) {
        this (carro.getPlaca(), carro.getChassi(), carro.getCor(), carro.getValorDiaria() , carro.getModelo().getId() ,carro.getAcessorios());
    }
}
