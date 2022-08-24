package py.gov.mspbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import py.gov.mspbs.entity.Plazas;

import java.util.Optional;

public interface PlazasRepository extends JpaRepository<Plazas, Long> {

    public Optional<Plazas> findByInstitucionEstablecimientoId(Long establecimientoId);

}
