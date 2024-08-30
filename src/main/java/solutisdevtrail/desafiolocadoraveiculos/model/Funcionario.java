package solutisdevtrail.desafiolocadoraveiculos.model;

import jakarta.persistence.*;

@Entity
@Table(name = "funcionarios")
public class Funcionario extends Pessoa {

    @Column(nullable = false, unique = true)
    private String matricula;


    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}
