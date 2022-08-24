package py.gov.mspbs.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import py.gov.mspbs.entity.ConvenioTutor;

import java.util.List;

public interface ConvenioTutorRepository extends JpaRepository<ConvenioTutor, Long> {

    List<ConvenioTutor> findByConvenioId(Long convenioId);

	Page<ConvenioTutor> findByConvenioId(Long convenioId, Pageable pageable);
}
