package solutisdevtrail.desafiolocadoraveiculos.model.entity;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Funcionario extends Pessoa{
        private String matricula;
}
