package py.gov.mspbs.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import py.gov.mspbs.entity.ConvenioMateria;


import java.util.List;

public interface ConvenioMateriaRepository extends JpaRepository<ConvenioMateria, Long> {

    List<ConvenioMateria> findByConvenioId(Long convenioId);

    Page<ConvenioMateria> findByConvenioId(Long convenioId, Pageable pageable);

}
