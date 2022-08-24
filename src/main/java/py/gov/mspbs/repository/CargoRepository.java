/**
 * 
 */
package py.gov.mspbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import py.gov.mspbs.entity.Cargo;

public interface CargoRepository extends JpaRepository<Cargo, Integer> {

}