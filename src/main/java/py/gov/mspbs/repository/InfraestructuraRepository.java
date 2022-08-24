package py.gov.mspbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import py.gov.mspbs.entity.Infraestructura;

import java.util.Optional;

public interface InfraestructuraRepository extends JpaRepository<Infraestructura, Long> {

    public Optional<Infraestructura> findByInstitucionEstablecimientoId(Long establecimientoId);

}
