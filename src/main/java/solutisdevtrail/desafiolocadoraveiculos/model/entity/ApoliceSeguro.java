//package solutisdevtrail.desafiolocadoraveiculos.model.entity;
//
//import jakarta.persistence.*;
//import lombok.Data;
//
//import java.math.BigDecimal;
//
//@Data
//@Entity
//public class ApoliceSeguro {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private BigDecimal valorFranquia;
//    private boolean protecaoTerceiro;
//    private boolean protecaoCausasNaturais;
//    private boolean protecaoRoubo;
//
//    @OneToOne(mappedBy = "apolice")
//    private Aluguel aluguel;
//}
