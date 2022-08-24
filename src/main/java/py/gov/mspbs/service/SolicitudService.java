package py.gov.mspbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import py.gov.mspbs.entity.ConvenioDocumentosRespaldo;
import py.gov.mspbs.entity.Solicitud;
import py.gov.mspbs.repository.SolicitudRepository;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class SolicitudService {

    @Autowired
    private SolicitudRepository solicitudRepository;

    public Solicitud findByConvenioId(@PathVariable("convenioId") Long convenioId) {
        return solicitudRepository.findByConvenioId(convenioId);
    }

    public Optional<Solicitud> findById(@PathVariable("id") Long id) {
        return solicitudRepository.findById(id);
    }

    @Transactional
    public Solicitud save(Solicitud solicitud) {
        return solicitudRepository.save(solicitud);
    }

    @Transactional
    public Solicitud update(Solicitud solicitud) {
        return solicitudRepository.save(solicitud);

    }

    @Transactional
    public void delete(Long id) {
        solicitudRepository.deleteById(id);
    }

}
