package py.gov.mspbs.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import py.gov.mspbs.entity.ConvenioCarreraPrograma;

public interface ConvenioCarreraProgramaRepository extends JpaRepository<ConvenioCarreraPrograma, Long> {

    List<ConvenioCarreraPrograma> findByConvenioId(Long ConvenioId);

	Page<ConvenioCarreraPrograma> findByConvenioId(Long convenioId, Pageable pageable);

    List<ConvenioCarreraPrograma> findByCarreraProgramaId(Long carreraId);

}
