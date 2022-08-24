package py.gov.mspbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import py.gov.mspbs.entity.ConvenioRector;
import py.gov.mspbs.repository.ConvenioRectorRepository;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class ConvenioRectorService {

    @Autowired
    private ConvenioRectorRepository convenioRectorRepository;

    public ConvenioRector findbyConvenioId(@PathVariable("convenioId") Long convenioId){
        return convenioRectorRepository.findConvenioRectorByConvenioId(convenioId);
    }

    public Optional<ConvenioRector> findById(@PathVariable("id") Long id) {
        return convenioRectorRepository.findById(id);
    }

    @Transactional
    public ConvenioRector save(ConvenioRector convenioRector) {
        return convenioRectorRepository.save(convenioRector);
    }

    @Transactional
    public ConvenioRector update(ConvenioRector convenioRector) {
        return convenioRectorRepository.save(convenioRector);

    }

    @Transactional
    public void delete(Long id) {
        convenioRectorRepository.deleteById(id);
    }

}
