package solutisdevtrail.desafiolocadoraveiculos.repository;

import solutisdevtrail.desafiolocadoraveiculos.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
}
