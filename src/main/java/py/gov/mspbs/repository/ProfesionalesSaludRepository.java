package py.gov.mspbs.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import py.gov.mspbs.entity.ProfesionalesSalud;

import java.util.Optional;

public interface ProfesionalesSaludRepository extends JpaRepository<ProfesionalesSalud, Long> {

    public Optional<ProfesionalesSalud> findByInstitucionEstablecimientoId(Long establecimientoId);

}
