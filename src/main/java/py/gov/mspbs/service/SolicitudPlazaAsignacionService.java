package py.gov.mspbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import py.gov.mspbs.entity.SolicitudPlazaAsignacion;
import py.gov.mspbs.repository.SolicitudPlazaAsignacionRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class SolicitudPlazaAsignacionService {

    @Autowired
    private SolicitudPlazaAsignacionRepository solicitudPlazaAsignacionRepository;


    public List<SolicitudPlazaAsignacion> findAll() {
        return solicitudPlazaAsignacionRepository.findAll();
    }

    public Optional<SolicitudPlazaAsignacion> findById(@PathVariable("id") Long id) {
        return solicitudPlazaAsignacionRepository.findById(id);
    }

    public List<SolicitudPlazaAsignacion> findBySolicitudPlazaId(@PathVariable("id") Long id) {
        return solicitudPlazaAsignacionRepository.findBySolicitudPlazaId(id);
    }

    public List<SolicitudPlazaAsignacion> findBySolicitudPlaza_Convenio_InstitucionFormadoraIdAndSolicitudPlaza_CarreraprogramaId(@PathVariable("idFormadora") Long idFormadora, @PathVariable("idCarrera") Long idCarrera) {
        return solicitudPlazaAsignacionRepository.findBySolicitudPlaza_Convenio_InstitucionFormadoraIdAndSolicitudPlaza_CarreraprogramaId(idFormadora, idCarrera);
    }

    @Transactional
    public SolicitudPlazaAsignacion save(SolicitudPlazaAsignacion solicitudPlazaAsignacion) {
        return solicitudPlazaAsignacionRepository.save(solicitudPlazaAsignacion);
    }

    @Transactional
    public SolicitudPlazaAsignacion update(SolicitudPlazaAsignacion solicitudPlazaAsignacion) {
        return solicitudPlazaAsignacionRepository.save(solicitudPlazaAsignacion);

    }

    @Transactional
    public void delete(Long id) {
        solicitudPlazaAsignacionRepository.deleteById(id);
    }
}
