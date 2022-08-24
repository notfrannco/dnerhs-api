/**
 * 
 */
package py.gov.mspbs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import py.gov.mspbs.entity.Ciudad;

public interface CiudadRepository extends JpaRepository<Ciudad, Integer> {

	List<Ciudad> findByDepartamento(Long idDepartamento);

	List<Ciudad> findByDepartamentoId(Long idDepartamento);
}