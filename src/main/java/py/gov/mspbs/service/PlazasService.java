package py.gov.mspbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import py.gov.mspbs.entity.Plazas;
import py.gov.mspbs.repository.PlazasRepository;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PlazasService {

    @Autowired
    private PlazasRepository plazasRepository;

    public Optional<Plazas> findById(@PathVariable("id") Long id){
        return plazasRepository.findById(id);
    }

    public Optional<Plazas> findByInstitucionEstablecimientoId(Long establecimientoId){
        return plazasRepository.findByInstitucionEstablecimientoId(establecimientoId);
    }

    @Transactional
    public Plazas save(Plazas plazas) {
        return plazasRepository.save(plazas);
    }

    @Transactional
    public Plazas update(Plazas plazas) {
        return plazasRepository.save(plazas);
    }

    @Transactional
    public void delete(Long id) {
        plazasRepository.deleteById(id);
    }

}
