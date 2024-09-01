package solutisdevtrail.desafiolocadoraveiculos.model.dto;

import solutisdevtrail.desafiolocadoraveiculos.model.entity.Aluguel;

import java.math.BigDecimal;
import java.util.Date;

public record AluguelDTO(Long id, Date dataPedido, Date dataEntrega, Date dataDevolucao, BigDecimal valorTotal,
                         //Long carroId,
                         Long motoristaId, Long apoliceId) {
    public AluguelDTO(Aluguel aluguel) {
        this(aluguel.getId(), aluguel.getDataPedido(), aluguel.getDataEntrega(),
                aluguel.getDataDevolucao(), aluguel.getValorTotal(),
                //aluguel.getCarro().getId()
                 aluguel.getMotorista().getId(),
                aluguel.getApolice() != null ? aluguel.getApolice().getId() : null);
    }
}
