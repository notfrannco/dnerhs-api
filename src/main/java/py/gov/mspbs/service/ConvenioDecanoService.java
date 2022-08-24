package py.gov.mspbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import py.gov.mspbs.entity.ConvenioDecano;
import py.gov.mspbs.repository.ConvenioDecanoRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class ConvenioDecanoService {

    @Autowired
    private ConvenioDecanoRepository convenioDecanoRepository;

    public List<ConvenioDecano> findByConvenioId(@PathVariable("convenioId") Long convenioId) {
        return convenioDecanoRepository.findByConvenioId(convenioId);
    }

    public Page<ConvenioDecano> getPageConvenioDocenteByConvenioId(@PathVariable("convenioId") Long convenioId, Pageable pageable) {
        return convenioDecanoRepository.findByConvenioId(convenioId, pageable);
    }

    public Optional<ConvenioDecano> findById(@PathVariable("id") Long id) {
        return convenioDecanoRepository.findById(id);
    }

    public Page<ConvenioDecano> getPage(Pageable pageable) {
        return convenioDecanoRepository.findAll(pageable);
    }


    @Transactional
    public ConvenioDecano save(ConvenioDecano convenioDecano) {
        return convenioDecanoRepository.save(convenioDecano);
    }

    @Transactional
    public ConvenioDecano update(ConvenioDecano convenioDecano) {
        return convenioDecanoRepository.save(convenioDecano);

    }

    @Transactional
    public void delete(Long id) {
        convenioDecanoRepository.deleteById(id);
    }
}
