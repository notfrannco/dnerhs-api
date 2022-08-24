package py.gov.mspbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import py.gov.mspbs.entity.Encargado;
import py.gov.mspbs.entity.Infraestructura;
import py.gov.mspbs.repository.InfraestructuraRepository;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class InfraestructuraService {

    @Autowired
    private InfraestructuraRepository infraestructuraRepository;

    public Optional<Infraestructura> findById(@PathVariable("id") Long id){
        return infraestructuraRepository.findById(id);
    }

    public Optional<Infraestructura> findByInstitucionEstablecimientoId(
            @PathVariable("establecimientoId") Long establecimientoId
    ){
        return infraestructuraRepository.findByInstitucionEstablecimientoId(establecimientoId);
    }

    @Transactional
    public Infraestructura save(Infraestructura infraestructura){
        return infraestructuraRepository.save(infraestructura);
    }

    @Transactional
    public Infraestructura update(Infraestructura infraestructura){
        return infraestructuraRepository.save(infraestructura);
    }

    @Transactional
    public void delete(Long id) {
        infraestructuraRepository.deleteById(id);
    }


}
