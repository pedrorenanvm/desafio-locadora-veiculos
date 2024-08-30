package solutisdevtrail.desafiolocadoraveiculos.model.dto;

import java.util.Date;
import java.math.BigDecimal;

public record AluguelDTO(Date dataPedido, Date dataEntrega, Date dataDevolucao, BigDecimal valorTotal, Long carroId, Long motoristaId) {
}
