package py.gov.mspbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import py.gov.mspbs.entity.PracticaDetalle;

import java.util.List;

public interface PracticaEstudianteRepository extends JpaRepository<PracticaDetalle, Long> {

    //List<PracticaDetalle> findByPracticaId(Long practicaId);

}
