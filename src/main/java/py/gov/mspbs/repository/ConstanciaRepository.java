package py.gov.mspbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.PathVariable;
import py.gov.mspbs.entity.Constancia;
import py.gov.mspbs.entity.ConstanciaDetalle;

import java.util.List;

public interface ConstanciaRepository extends JpaRepository<Constancia, Long> {


    List<Constancia> findAllByCedulaIdentidad(Integer cedula);


}
