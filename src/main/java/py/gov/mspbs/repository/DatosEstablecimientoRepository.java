package py.gov.mspbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import py.gov.mspbs.entity.DatosEstablecimiento;

import java.util.List;
import java.util.Optional;

public interface DatosEstablecimientoRepository extends JpaRepository<DatosEstablecimiento, Long> {

    public Optional<DatosEstablecimiento> findByInstitucionEstablecimientoId(Long establecimientoId);

    public List<DatosEstablecimiento> findByRegionSanitariaId(Long regionSanitariaId);

}
