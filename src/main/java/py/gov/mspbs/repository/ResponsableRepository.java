/**
 * 
 */
package py.gov.mspbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import py.gov.mspbs.entity.Responsable;
import py.gov.mspbs.entity.Usuario;

public interface ResponsableRepository extends JpaRepository<Responsable, Long> {

    //Responsable findResponsableByUsuario(Usuario usuario);

}