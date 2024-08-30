package solutisdevtrail.desafiolocadoraveiculos.repository;

import solutisdevtrail.desafiolocadoraveiculos.model.entity.Fabricante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FabricanteRepository extends JpaRepository<Fabricante, Long> {
}
