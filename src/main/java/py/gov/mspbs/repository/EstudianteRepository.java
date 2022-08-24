package py.gov.mspbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import py.gov.mspbs.entity.Estudiante;

public interface EstudianteRepository extends JpaRepository <Estudiante, Long> {

}
