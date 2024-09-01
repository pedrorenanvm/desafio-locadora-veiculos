package solutisdevtrail.desafiolocadoraveiculos.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Data
@Entity
public class Carro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String placa;
    private String chassi;
    private String cor;
    private BigDecimal valorDiaria;

    @OneToMany(mappedBy = "carro")
    private List<Aluguel> alugueis;

    @ManyToOne
    @JoinColumn(name = "modelo_id")
    private ModeloCarro modelo;

    @ManyToMany
    @JoinTable(
            name = "carro_acessorio",
            joinColumns = @JoinColumn(name = "carro_id"),
            inverseJoinColumns = @JoinColumn(name = "acessorio_id"))
    private Set<Acessorio> acessorios;
}
