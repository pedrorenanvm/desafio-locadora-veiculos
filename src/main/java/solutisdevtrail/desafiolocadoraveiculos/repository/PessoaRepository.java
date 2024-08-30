package solutisdevtrail.desafiolocadoraveiculos.repository;

import solutisdevtrail.desafiolocadoraveiculos.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
