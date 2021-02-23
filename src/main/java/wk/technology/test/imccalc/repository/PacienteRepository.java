package wk.technology.test.imccalc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wk.technology.test.imccalc.domain.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
