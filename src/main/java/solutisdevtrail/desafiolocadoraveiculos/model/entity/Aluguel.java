package solutisdevtrail.desafiolocadoraveiculos.model.entity;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
@Data
@Entity
public class Aluguel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Calendar dataPedido;
    private Date dataEntrega;
    private Date dataDevolucao;
    private BigDecimal valorTotal;

    @ManyToOne
    @JoinColumn(name = "carro_id")
    private Carro carro;

    @ManyToOne
    @JoinColumn(name = "motorista_id")
    private Motorista motorista;

    @OneToOne
    @JoinColumn(name = "apolice_id")
    private ApoliceSeguro apolice;

}
