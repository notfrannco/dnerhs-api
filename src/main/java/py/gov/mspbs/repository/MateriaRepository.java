/**
 * 
 */
package py.gov.mspbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import py.gov.mspbs.entity.Materia;

public interface MateriaRepository extends JpaRepository<Materia, Long> {

}