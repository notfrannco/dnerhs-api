package py.gov.mspbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import py.gov.mspbs.entity.Servicios;
import py.gov.mspbs.repository.ServiciosRepository;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class ServiciosService {

    @Autowired
    private ServiciosRepository serviciosRepository;

    public Optional<Servicios> findById(@PathVariable("id") Long id){
        return serviciosRepository.findById(id);
    }

    public Optional<Servicios> findByInstitucionEstablecimientoId(
            @PathVariable("establecimientoId") Long establecimientoId){
        return serviciosRepository.findByInstitucionEstablecimientoId(establecimientoId);
    }

    @Transactional
    public Servicios save(Servicios servicios) {
        return serviciosRepository.save(servicios);
    }

    @Transactional
    public Servicios update(Servicios servicios) {
        return serviciosRepository.save(servicios);
    }

    @Transactional
    public void delete(Long id) {
        serviciosRepository.deleteById(id);
    }

}
