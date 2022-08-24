package py.gov.mspbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import py.gov.mspbs.entity.Servicios;

import java.util.Optional;

public interface ServiciosRepository extends JpaRepository<Servicios, Long> {

    public Optional <Servicios> findByInstitucionEstablecimientoId(Long establecimientoId);

}
