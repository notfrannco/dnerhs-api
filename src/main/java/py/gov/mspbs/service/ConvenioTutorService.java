package py.gov.mspbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import py.gov.mspbs.entity.ConvenioCarreraPrograma;
import py.gov.mspbs.entity.ConvenioTutor;
import py.gov.mspbs.repository.ConvenioTutorRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class ConvenioTutorService {

    @Autowired
    private ConvenioTutorRepository convenioTutorRepository;
    
    public Page<ConvenioTutor> getPageByConvenioId(@PathVariable("convenioId") Long convenioId, Pageable pageable) {
        return convenioTutorRepository.findByConvenioId(convenioId, pageable);
    }

    public List<ConvenioTutor> findByConvenioId(@PathVariable("convenioId") Long convenioId) {
        return convenioTutorRepository.findByConvenioId(convenioId);
    }

    public Optional<ConvenioTutor> findById(@PathVariable("id") Long id) {
        return convenioTutorRepository.findById(id);
    }

    @Transactional
    public ConvenioTutor save(ConvenioTutor convenioTutor) {
        return convenioTutorRepository.save(convenioTutor);
    }

    @Transactional
    public ConvenioTutor update(ConvenioTutor convenioTutor) {
        return convenioTutorRepository.save(convenioTutor);

    }

    @Transactional
    public void delete(Long id) {
        convenioTutorRepository.deleteById(id);
    }


}
