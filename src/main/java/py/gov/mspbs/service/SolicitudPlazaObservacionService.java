package py.gov.mspbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import py.gov.mspbs.entity.SolicitudPlazaObservacion;
import py.gov.mspbs.repository.SolicitudPlazaObservacionRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class SolicitudPlazaObservacionService {

    @Autowired
    private SolicitudPlazaObservacionRepository solicitudPlazaObservacionRepository;


    public List<SolicitudPlazaObservacion> findAll() {
        return solicitudPlazaObservacionRepository.findAll();
    }

    public Optional<SolicitudPlazaObservacion> findById(@PathVariable("id") Long id) {
        return solicitudPlazaObservacionRepository.findById(id);
    }

    public List<SolicitudPlazaObservacion> findBySolicitudPlazaId(@PathVariable("id") Long id) {
        return solicitudPlazaObservacionRepository.findBySolicitudPlazaId(id);
    }

    @Transactional
    public SolicitudPlazaObservacion save(SolicitudPlazaObservacion solicitudPlazaObservacion) {
        return solicitudPlazaObservacionRepository.save(solicitudPlazaObservacion);
    }

    @Transactional
    public SolicitudPlazaObservacion update(SolicitudPlazaObservacion solicitudPlazaObservacion) {
        return solicitudPlazaObservacionRepository.save(solicitudPlazaObservacion);

    }

    @Transactional
    public void delete(Long id) {
        solicitudPlazaObservacionRepository.deleteById(id);
    }
}
