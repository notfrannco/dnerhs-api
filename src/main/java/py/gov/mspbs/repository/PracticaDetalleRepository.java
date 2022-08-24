package py.gov.mspbs.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import py.gov.mspbs.entity.PracticaDetalle;

import java.util.List;

public interface PracticaDetalleRepository extends JpaRepository<PracticaDetalle, Long> {

    List<PracticaDetalle> findByEstablecimientoId (Long establecimientoId);

    Page<PracticaDetalle> findByEstablecimientoId (Long establecimientoId, Pageable pageable);

    @Query(value = "SELECT pd.practica_id from practica_detalle pd where pd.id = ?1", nativeQuery = true)
    Long getPracticaId(Long practicaDetalleId);

    List<PracticaDetalle> findByConvenioEstudianteId(Long convenioEstudianteId);

}
