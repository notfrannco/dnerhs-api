package py.gov.mspbs.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import py.gov.mspbs.entity.SolicitudPlazaObservacion;

public interface SolicitudPlazaObservacionRepository extends JpaRepository<SolicitudPlazaObservacion, Long> {
  List<SolicitudPlazaObservacion> findBySolicitudPlazaId(Long idSolicitudPlaza);
  Optional<SolicitudPlazaObservacion> findById(Long id);
}
