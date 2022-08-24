package py.gov.mspbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import py.gov.mspbs.entity.PracticaObservacion;
import py.gov.mspbs.repository.PracticaObservacionRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PracticaObservacionService {

    @Autowired
    private PracticaObservacionRepository practicaObservacionRepository;


    public List<PracticaObservacion> findAll() {
        return practicaObservacionRepository.findAll();
    }

    public Optional<PracticaObservacion> findById(@PathVariable("id") Long id) {
        return practicaObservacionRepository.findById(id);
    }

    public List<PracticaObservacion> findByPracticaId(@PathVariable("id") Long id) {
        return practicaObservacionRepository.findByPracticaId(id);
    }

    @Transactional
    public PracticaObservacion save(PracticaObservacion practicaObservacion) {
        return practicaObservacionRepository.save(practicaObservacion);
    }

    @Transactional
    public PracticaObservacion update(PracticaObservacion practicaObservacion) {
        return practicaObservacionRepository.save(practicaObservacion);

    }

    @Transactional
    public void delete(Long id) {
        practicaObservacionRepository.deleteById(id);
    }
}
