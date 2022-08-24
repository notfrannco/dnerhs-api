package py.gov.mspbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import py.gov.mspbs.entity.NombreServicio;

@Service
@Transactional(readOnly = true)
public interface NombreServicioRepository extends JpaRepository<NombreServicio, Long> {
}
