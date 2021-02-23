package wk.technology.test.imccalc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wk.technology.test.imccalc.domain.Estado;

import java.util.Optional;

public interface EstadoRepository  extends JpaRepository<Estado, Long> {
    Optional<Estado> findByUf(String uf);
}
