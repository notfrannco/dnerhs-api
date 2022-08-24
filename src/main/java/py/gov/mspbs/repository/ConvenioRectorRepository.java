package py.gov.mspbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import py.gov.mspbs.entity.ConvenioRector;

public interface ConvenioRectorRepository extends JpaRepository<ConvenioRector, Long> {

    ConvenioRector findConvenioRectorByConvenioId(Long ConvenioId);

}
