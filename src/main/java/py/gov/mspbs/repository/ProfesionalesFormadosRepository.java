package py.gov.mspbs.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import py.gov.mspbs.entity.ProfesionalesFormados;

public interface ProfesionalesFormadosRepository extends JpaRepository<ProfesionalesFormados, Long> {

    public Optional<ProfesionalesFormados> findByConvenioId(Long convenioId);

	public Page<ProfesionalesFormados> findByConvenioId(Long convenioId, Pageable pageable);

}
