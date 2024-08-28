package solutisdevtrail.desafiolocadoraveiculos.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Date dataNascimento;
    private String cpf;

}
