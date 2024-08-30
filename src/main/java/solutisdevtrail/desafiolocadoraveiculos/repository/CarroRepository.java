package solutisdevtrail.desafiolocadoraveiculos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import solutisdevtrail.desafiolocadoraveiculos.model.entity.Carro;

public interface CarroRepository extends JpaRepository<Carro, Long> {
    // Métodos de consulta adicionais, se necessário
}
