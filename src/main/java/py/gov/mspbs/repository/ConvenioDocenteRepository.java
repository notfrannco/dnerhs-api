package py.gov.mspbs.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import py.gov.mspbs.entity.ConvenioDocente;

import java.util.List;

public interface ConvenioDocenteRepository extends JpaRepository<ConvenioDocente, Long> {

    List<ConvenioDocente> findByConvenioId(Long ConvenioId);

    Page<ConvenioDocente> findByConvenioId(Long ConvenioId, Pageable pageable);

}
