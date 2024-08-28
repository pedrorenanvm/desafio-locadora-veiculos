package solutisdevtrail.desafiolocadoraveiculos.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Motorista extends Pessoa{
    private String numeroCNH;

    @OneToMany(mappedBy = "motorista")
    private List<Aluguel> alugueis;

}
