package solutisdevtrail.desafiolocadoraveiculos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import solutisdevtrail.desafiolocadoraveiculos.model.entity.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
