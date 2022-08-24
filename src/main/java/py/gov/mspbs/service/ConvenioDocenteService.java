package py.gov.mspbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import py.gov.mspbs.entity.ConvenioDocente;
import py.gov.mspbs.repository.ConvenioDocenteRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class ConvenioDocenteService {
    
    @Autowired
    private ConvenioDocenteRepository convenioDocenteRepository;

    public List<ConvenioDocente> findByConvenioId(@PathVariable("convenioId") Long convenioId) {
        return convenioDocenteRepository.findByConvenioId(convenioId);
    }

    public Page<ConvenioDocente> getPageConvenioDocenteByConvenioId(@PathVariable("convenioId") Long convenioId, Pageable pageable) {
        return convenioDocenteRepository.findByConvenioId(convenioId, pageable);
    }

    public Page<ConvenioDocente> getPage(Pageable pageable) {
        return convenioDocenteRepository.findAll(pageable);
    }

    public Optional<ConvenioDocente> findById(@PathVariable("id") Long id) {
        return convenioDocenteRepository.findById(id);
    }

    @Transactional
    public ConvenioDocente save(ConvenioDocente convenioDocente) {
        return convenioDocenteRepository.save(convenioDocente);
    }

    @Transactional
    public ConvenioDocente update(ConvenioDocente convenioDocente) {
        return convenioDocenteRepository.save(convenioDocente);
    }

    @Transactional
    public void delete(Long id) {
        convenioDocenteRepository.deleteById(id);
    }
    
}
