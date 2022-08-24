package py.gov.mspbs.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import py.gov.mspbs.entity.Practica;

public interface ConvenioPracticaRepository extends JpaRepository<Practica, Long> {

    List<Practica> findByConvenioId(Long convenioId);
    
    Page<Practica> findByConvenioId(Long convenioId, Pageable pageable);

	Page<Practica> findByConvenioIdAndEstadoIn(Long convenioId, List<String> estado, Pageable pageable);
	
}
