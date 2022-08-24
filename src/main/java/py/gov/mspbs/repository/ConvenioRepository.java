package py.gov.mspbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import py.gov.mspbs.entity.Convenio;

import java.util.Date;
import java.util.List;


public interface ConvenioRepository extends JpaRepository<Convenio, Long> {

    List<Convenio> findConvenioListByInstitucionFormadoraId(Long institucionFormadoraId);

    List<Convenio> findConveniosByInstitucionFormadoraIdAndEstado(Long institucionFormadora, String estado);

    List<Convenio> findConveniosByEstado(String estado);

    List<Convenio> findConveniosByFechaInicioVigenciaLessThanEqualAndFechaFinVigenciaGreaterThanEqualAndEstado(
            Date actual1, Date actual2, String estado);

}
