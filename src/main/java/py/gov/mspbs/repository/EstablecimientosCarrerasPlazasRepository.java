/**
 * 
 */
package py.gov.mspbs.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import py.gov.mspbs.entity.EstablecimientosCarrerasPlazas;

public interface EstablecimientosCarrerasPlazasRepository extends JpaRepository<EstablecimientosCarrerasPlazas, Long> {
  List<EstablecimientosCarrerasPlazas> findByNombreServicioId(Long idNombreServicio);
  Optional<EstablecimientosCarrerasPlazas> findById(Long id);
  Optional<EstablecimientosCarrerasPlazas> findByNombreServicioIdAndCarreraprogramaId(Long idNombreServicio, Long idCarreraprograma);
}