package py.gov.mspbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import py.gov.mspbs.entity.MaximaAutoridad;
import py.gov.mspbs.repository.MaximaAutoridadRepository;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class MaximaAutoridadService {

    @Autowired
    private MaximaAutoridadRepository maximaAutoridadRepository;

    @Transactional
    public MaximaAutoridad save (MaximaAutoridad maximaAutoridad) {
        return maximaAutoridadRepository.save(maximaAutoridad);
    }

    public Optional<MaximaAutoridad> findbyId(@PathVariable("id") Long id) {
        return maximaAutoridadRepository.findById(id);
    }

    public List<MaximaAutoridad> findAll() {
        return maximaAutoridadRepository.findAll();
    }

    @Transactional
    public MaximaAutoridad update(MaximaAutoridad maximaAutoridad){
        return maximaAutoridadRepository.save(maximaAutoridad);
    }

}
