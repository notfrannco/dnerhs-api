/**
 * 
 */
package py.gov.mspbs.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import py.gov.mspbs.entity.InstitucionFormadoraResponsableMaximaAutoridad;

import java.util.List;

public interface InstitucionFormadoraResponsableMaximaAutoridadRepository extends JpaRepository<InstitucionFormadoraResponsableMaximaAutoridad, Long> {

    List<InstitucionFormadoraResponsableMaximaAutoridad> findInstitucionFormadoraResponsableByEstado(String estado);

    Page<InstitucionFormadoraResponsableMaximaAutoridad> findInstitucionFormadoraResponsableByEstado(String estado, Pageable pageable);

    InstitucionFormadoraResponsableMaximaAutoridad findInstitucionFormadoraResponsableByResponsableId(Long responsableId);

    InstitucionFormadoraResponsableMaximaAutoridad findByFormadoraId(Long formadoraId);

}