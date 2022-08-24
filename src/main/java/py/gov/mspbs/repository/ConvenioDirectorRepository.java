package py.gov.mspbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import py.gov.mspbs.entity.ConvenioDirector;

public interface ConvenioDirectorRepository extends JpaRepository<ConvenioDirector, Long> {

    ConvenioDirector findConvenioDirectorByConvenioId(Long convenioId);

}