package py.gov.mspbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import py.gov.mspbs.entity.Encargado;

import java.util.Optional;

public interface EncargadoRepository extends JpaRepository<Encargado, Long> {

    public Optional<Encargado> findByInstitucionEstablecimientoId(Long establecimientoId);

}
