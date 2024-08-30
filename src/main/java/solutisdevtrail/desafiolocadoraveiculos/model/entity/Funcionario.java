package solutisdevtrail.desafiolocadoraveiculos.model.entity;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Funcionario extends Pessoa{
        private String matricula;
}
