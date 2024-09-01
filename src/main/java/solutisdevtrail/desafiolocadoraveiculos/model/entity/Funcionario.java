package solutisdevtrail.desafiolocadoraveiculos.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "funcionario")
@Data
public class Funcionario extends Pessoa {
        private String matricula;
}
