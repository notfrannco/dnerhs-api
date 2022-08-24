/**
 * 
 */
package py.gov.mspbs.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import py.gov.mspbs.entity.EstablecimientosCarrerasPlazasObservaciones;

public interface EstablecimientosCarrerasPlazasObservacionesRepository extends JpaRepository<EstablecimientosCarrerasPlazasObservaciones, Long> {
  List<EstablecimientosCarrerasPlazasObservaciones> findByEstablecimientoCarreraPlazaId(Long idEstablecimientoCarreraPlaza);
  Optional<EstablecimientosCarrerasPlazasObservaciones> findById(Long id);
}