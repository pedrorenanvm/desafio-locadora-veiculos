package solutisdevtrail.desafiolocadoraveiculos.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
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

    @Column(unique = true)
    private String cpf;

    @Column(unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    private Sexo sexo;
}
