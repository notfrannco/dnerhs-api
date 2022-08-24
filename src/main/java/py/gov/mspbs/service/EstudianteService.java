package py.gov.mspbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import py.gov.mspbs.entity.Estudiante;
import py.gov.mspbs.entity.Tutor;
import py.gov.mspbs.repository.EstudianteRepository;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    public Optional<Estudiante> findById(@PathVariable("id") Long id) {
        return estudianteRepository.findById(id);
    }

    @Transactional
    public Estudiante save(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    @Transactional
    public Estudiante update(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    @Transactional
    public void delete(Long id) {
        estudianteRepository.deleteById(id);
    }
}
