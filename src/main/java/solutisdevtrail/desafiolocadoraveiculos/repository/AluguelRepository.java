package solutisdevtrail.desafiolocadoraveiculos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import solutisdevtrail.desafiolocadoraveiculos.model.entity.Aluguel;

public interface AluguelRepository extends JpaRepository<Aluguel, Long> {
    // Métodos de consulta adicionais, se necessário
}
