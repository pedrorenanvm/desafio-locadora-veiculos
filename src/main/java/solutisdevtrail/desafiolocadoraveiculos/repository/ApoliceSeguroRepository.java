package solutisdevtrail.desafiolocadoraveiculos.repository;

import solutisdevtrail.desafiolocadoraveiculos.model.entity.ApoliceSeguro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApoliceSeguroRepository extends JpaRepository<ApoliceSeguro, Long> {
}
