package solutisdevtrail.desafiolocadoraveiculos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import solutisdevtrail.desafiolocadoraveiculos.model.entity.Carro;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Long> {
    // Métodos de consulta adicionais, se necessário
}
