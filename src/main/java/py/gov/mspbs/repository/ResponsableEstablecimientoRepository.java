package py.gov.mspbs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import py.gov.mspbs.entity.ResponsableEstablecimiento;

public interface ResponsableEstablecimientoRepository extends JpaRepository<ResponsableEstablecimiento, Long> {
        List<ResponsableEstablecimiento> findByCedulaIdentidad(Integer cedula);
}
