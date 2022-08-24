package py.gov.mspbs.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import py.gov.mspbs.entity.PracticaObservacion;

public interface PracticaObservacionRepository extends JpaRepository<PracticaObservacion, Long> {
  List<PracticaObservacion> findByPracticaId(Long idPractica);
  Optional<PracticaObservacion> findById(Long id);
}
