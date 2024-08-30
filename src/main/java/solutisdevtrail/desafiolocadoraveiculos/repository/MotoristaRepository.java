package solutisdevtrail.desafiolocadoraveiculos.repository;

import solutisdevtrail.desafiolocadoraveiculos.model.Motorista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MotoristaRepository extends JpaRepository<Motorista, Long> {
}
