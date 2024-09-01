package solutisdevtrail.desafiolocadoraveiculos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import solutisdevtrail.desafiolocadoraveiculos.model.entity.Carro;

import java.util.Optional;

public interface CarroRepository extends JpaRepository<Carro, Long> {

    Optional<Carro> findByChassi(String chassi);

    Optional<Carro> findByPlaca(String placa);
}
