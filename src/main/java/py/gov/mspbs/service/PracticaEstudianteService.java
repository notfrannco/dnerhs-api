package py.gov.mspbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import py.gov.mspbs.entity.PracticaDetalle;
import py.gov.mspbs.repository.PracticaEstudianteRepository;


import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PracticaEstudianteService {

    @Autowired
    PracticaEstudianteRepository practicaEstudianteRepository;

//    public List<PracticaDetalle> findByPracticaId(@PathVariable("practicaId") Long practicaId) {
//        return practicaEstudianteRepository.findByPracticaId(practicaId);
//    }

    public Optional<PracticaDetalle> findById(@PathVariable("id") Long id) {
        return practicaEstudianteRepository.findById(id);
    }

    @Transactional
    public PracticaDetalle save(PracticaDetalle practicaDetalle) {
        return practicaEstudianteRepository.save(practicaDetalle);
    }

    @Transactional
    public PracticaDetalle update(PracticaDetalle practicaDetalle) {
        return practicaEstudianteRepository.save(practicaDetalle);
    }

    @Transactional
    public void delete(Long id) {
        practicaEstudianteRepository.deleteById(id);
    }

}
