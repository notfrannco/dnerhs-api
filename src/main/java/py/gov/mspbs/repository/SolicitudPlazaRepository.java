package py.gov.mspbs.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import py.gov.mspbs.entity.Convenio;
import py.gov.mspbs.entity.DatosEstablecimiento;
import py.gov.mspbs.entity.SolicitudPlaza;

public interface SolicitudPlazaRepository extends JpaRepository<SolicitudPlaza, Long> {

  Page<SolicitudPlaza> findByDatosEstablecimientoAndConvenio(DatosEstablecimiento datosEstablecimiento, Convenio convenio, Pageable pageable);
  Page<SolicitudPlaza> findByDatosEstablecimiento(DatosEstablecimiento datosEstablecimiento, Pageable pageable);
  Page<SolicitudPlaza> findByConvenio(Convenio convenio, Pageable pageable);
  Optional<SolicitudPlaza> findByEstadoAndConvenio_InstitucionFormadoraId(String estado, Long institucionFormadoraId);
  List<SolicitudPlaza> findByConvenio_InstitucionFormadoraIdAndCarreraprogramaId(Long institucionFormadoraId, Long carreraProgramaId);
}
