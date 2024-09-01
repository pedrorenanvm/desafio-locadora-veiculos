package solutisdevtrail.desafiolocadoraveiculos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import solutisdevtrail.desafiolocadoraveiculos.model.entity.Funcionario;

import java.util.Optional;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    Optional<Funcionario> findByCpf(String cpf);

    Optional<Funcionario> findByMatricula(String matricula);

    Optional<Funcionario> findByEmail(String email);
}
