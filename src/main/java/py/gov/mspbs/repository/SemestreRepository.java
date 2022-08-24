/**
 * 
 */
package py.gov.mspbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import py.gov.mspbs.entity.Semestre;

public interface SemestreRepository extends JpaRepository<Semestre, Integer> {

}