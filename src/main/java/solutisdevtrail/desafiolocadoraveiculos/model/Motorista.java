package solutisdevtrail.desafiolocadoraveiculos.model;

import jakarta.persistence.*;

@Entity
@Table(name = "motoristas")
public class Motorista extends Pessoa {

    @Column(nullable = false, unique = true)
    private String numeroCNH;


    public String getNumeroCNH() {
        return numeroCNH;
    }

    public void setNumeroCNH(String numeroCNH) {
        this.numeroCNH = numeroCNH;
    }
}
