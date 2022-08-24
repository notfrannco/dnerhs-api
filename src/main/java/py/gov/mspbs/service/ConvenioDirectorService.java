package py.gov.mspbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import py.gov.mspbs.entity.ConvenioDirector;
import py.gov.mspbs.entity.ConvenioRector;
import py.gov.mspbs.repository.ConvenioDirectorRepository;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class ConvenioDirectorService {

    @Autowired
    private ConvenioDirectorRepository convenioDirectorRepository;

    public ConvenioDirector findbyConvenioId(@PathVariable("convenioId") Long convenioId){
        return convenioDirectorRepository.findConvenioDirectorByConvenioId(convenioId);
    }

    public Optional<ConvenioDirector> findById(@PathVariable("id") Long id) {
        return convenioDirectorRepository.findById(id);
    }

    @Transactional
    public ConvenioDirector save(ConvenioDirector convenioDirector) {
        return convenioDirectorRepository.save(convenioDirector);
    }

    @Transactional
    public ConvenioDirector update(ConvenioDirector convenioDirector) {
        return convenioDirectorRepository.save(convenioDirector);

    }

    @Transactional
    public void delete(Long id) {
        convenioDirectorRepository.deleteById(id);
    }
}
