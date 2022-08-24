package py.gov.mspbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import py.gov.mspbs.entity.Solicitud;

public interface SolicitudRepository extends JpaRepository<Solicitud, Long> {

    Solicitud findByConvenioId(Long convenioId);

}

