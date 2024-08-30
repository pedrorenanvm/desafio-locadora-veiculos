package solutisdevtrail.desafiolocadoraveiculos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import solutisdevtrail.desafiolocadoraveiculos.model.entity.Motorista;

public interface MotoristaRepository extends JpaRepository<Motorista, Long> {
}
