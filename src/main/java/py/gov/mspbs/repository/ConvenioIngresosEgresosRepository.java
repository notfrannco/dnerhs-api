package py.gov.mspbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import py.gov.mspbs.entity.ConvenioIngresosEgresos;

import java.util.List;

public interface ConvenioIngresosEgresosRepository extends JpaRepository<ConvenioIngresosEgresos, Long> {

    List<ConvenioIngresosEgresos> findByConvenioId(Long convenioId);

}
