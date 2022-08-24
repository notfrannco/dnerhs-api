package py.gov.mspbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import py.gov.mspbs.entity.Practica;
import py.gov.mspbs.entity.PracticaDetalle;
import py.gov.mspbs.repository.PracticaDetalleRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PracticaDetalleService {

    @Autowired
    PracticaDetalleRepository practicaDetalleRepository;

    public List<PracticaDetalle> findByEstablecimientoId(
            @PathVariable("establecimientoId") Long establecimientoId) {
        return practicaDetalleRepository.findByEstablecimientoId(establecimientoId);
    }

    public List<PracticaDetalle> findByEstablecimientoId(
            @PathVariable("establecimientoId") Long establecimientoId,
            Pageable pageable) {
        return practicaDetalleRepository.findByEstablecimientoId(establecimientoId);
    }

    public List<PracticaDetalle> findByConvenioEstudianteId(Long convenioEstudianteId){
        return practicaDetalleRepository.findByConvenioEstudianteId(convenioEstudianteId);
    }

    public Long getPracticaId(Long practicaDetalleId){
        return practicaDetalleRepository.getPracticaId(practicaDetalleId);
    }

    @Transactional
    public PracticaDetalle save(PracticaDetalle practicaDetalle) {
        return practicaDetalleRepository.save(practicaDetalle);
    }

    @Transactional
    public PracticaDetalle update(PracticaDetalle practicaDetalle) {
        return practicaDetalleRepository.save(practicaDetalle);

    }

    @Transactional
    public void delete(Long id) {
        practicaDetalleRepository.deleteById(id);
    }

    public Optional<PracticaDetalle> findById(@PathVariable("id") Long id) {
        return practicaDetalleRepository.findById(id);
    }


}
