package py.gov.mspbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import py.gov.mspbs.entity.Archivo;

public interface ArchivoRepository extends JpaRepository<Archivo, String> {

}
