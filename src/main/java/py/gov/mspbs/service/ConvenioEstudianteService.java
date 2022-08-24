package py.gov.mspbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import py.gov.mspbs.entity.ConvenioEstudiante;
import py.gov.mspbs.repository.ConvenioEstudianteRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class ConvenioEstudianteService {

    @Autowired
    private ConvenioEstudianteRepository convenioEstudianteRepository;

    public List<ConvenioEstudiante> findByConvenioId(@PathVariable("convenioId") Long convenioId) {
        return convenioEstudianteRepository.findByConvenioId(convenioId);
    }

    public Page<ConvenioEstudiante> getPageFindByConvenioId(@PathVariable("convenioId") Long convenioId, Pageable pageable) {
        return convenioEstudianteRepository.findByConvenioId(convenioId, pageable);
    }

    public Optional<ConvenioEstudiante> findById(@PathVariable("id") Long id) {
        return convenioEstudianteRepository.findById(id);
    }

    @Transactional
    public ConvenioEstudiante save(ConvenioEstudiante convenioEstudiante) {
        return convenioEstudianteRepository.save(convenioEstudiante);
    }

    @Transactional
    public ConvenioEstudiante update(ConvenioEstudiante convenioEstudiante) {
        return convenioEstudianteRepository.save(convenioEstudiante);
    }

    @Transactional
    public void delete(Long id) {
        convenioEstudianteRepository.deleteById(id);
    }

}
