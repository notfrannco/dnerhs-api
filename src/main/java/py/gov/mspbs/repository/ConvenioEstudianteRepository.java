package py.gov.mspbs.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import py.gov.mspbs.entity.ConvenioEstudiante;

import java.util.List;

public interface ConvenioEstudianteRepository extends JpaRepository<ConvenioEstudiante, Long> {

    List<ConvenioEstudiante> findByConvenioId(Long convenioId);

    Page<ConvenioEstudiante> findByConvenioId(Long convenioId, Pageable pageable);

}
