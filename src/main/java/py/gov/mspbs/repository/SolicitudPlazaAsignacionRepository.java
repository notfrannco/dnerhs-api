package py.gov.mspbs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import py.gov.mspbs.entity.SolicitudPlazaAsignacion;

public interface SolicitudPlazaAsignacionRepository extends JpaRepository<SolicitudPlazaAsignacion, Long> {
  List<SolicitudPlazaAsignacion> findBySolicitudPlazaId(Long solicitudPlazaId);
  @Query(value = "SELECT spa.solicitud_plaza_id from solicitud_plaza_asignacion spa where spa.id = ?1", nativeQuery = true)
  Long getSolicitudPlazaId(Long solicitudPracticaAsignacionId);
  
  List<SolicitudPlazaAsignacion> findBySolicitudPlaza_Convenio_InstitucionFormadoraIdAndSolicitudPlaza_CarreraprogramaId(Long institucionFormadoraId, Long carreraProgramaId);
}
