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

    @Column(unique = true)
    private String placa;

    @Column(unique = true)
    private String chassi;

    private String cor;
    private BigDecimal valorDiaria;

    @Column(length = 500)
    private String especificacoesTecnicas;

    @Column(length = 250)
    private String descricao;

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
