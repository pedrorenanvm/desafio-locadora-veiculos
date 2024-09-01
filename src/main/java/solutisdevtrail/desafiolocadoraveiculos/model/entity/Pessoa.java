package solutisdevtrail.desafiolocadoraveiculos.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@MappedSuperclass
public abstract class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private Date dataNascimento;
    private String cpf;

    @Enumerated(EnumType.STRING)
    private Sexo sexo;
}
