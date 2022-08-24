package py.gov.mspbs.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import py.gov.mspbs.entity.ConvenioDecano;

import java.util.List;

public interface ConvenioDecanoRepository extends JpaRepository<ConvenioDecano, Long> {

    List<ConvenioDecano> findByConvenioId(Long ConvenioId);

    Page<ConvenioDecano> findByConvenioId(Long ConvenioId, Pageable pageable);

}
