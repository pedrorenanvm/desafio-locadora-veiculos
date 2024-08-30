package solutisdevtrail.desafiolocadoraveiculos.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Motorista extends Pessoa{
    private String numeroCNH;

    @OneToMany(mappedBy = "motorista")
    private List<Aluguel> alugueis;

}
