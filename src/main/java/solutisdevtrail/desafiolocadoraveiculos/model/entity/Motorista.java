package solutisdevtrail.desafiolocadoraveiculos.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "motorista")
public class Motorista extends Pessoa {
    @Column(unique = true)
    private String numeroCNH;

    @OneToMany(mappedBy = "motorista")
    private List<Aluguel> alugueis;
}
