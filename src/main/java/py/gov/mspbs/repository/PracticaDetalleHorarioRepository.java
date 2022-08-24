package py.gov.mspbs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import py.gov.mspbs.entity.PracticaDetalleHorario;

public interface PracticaDetalleHorarioRepository extends JpaRepository<PracticaDetalleHorario, Long> {
  List<PracticaDetalleHorario> findByPracticaDetalleId(Long practicaDetalleId);

  @Query(value = "SELECT pd.practica_detalle_id from practica_detalle_horario pd where pd.id = ?1", nativeQuery = true)
  Long getPracticaDetalleId(Long practicaDetalleHorarioId);
}
