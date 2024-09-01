//package solutisdevtrail.desafiolocadoraveiculos.model.entity;
//
//import jakarta.persistence.*;
//import lombok.Data;
//
//@Data
//@Entity
//public class ModeloCarro {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String descricao;
//
//    @Enumerated(EnumType.STRING)
//    private Categoria categoria;
//
//    @ManyToOne
//    @JoinColumn(name = "fabricante_id")
//    private Fabricante fabricante;
//}
