package py.gov.mspbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import py.gov.mspbs.entity.ConvenioMateria;
import py.gov.mspbs.repository.ConvenioMateriaRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class ConvenioMateriaService {

    @Autowired
    private ConvenioMateriaRepository convenioMateriaRepository;

    public List<ConvenioMateria> findByConvenioId(@PathVariable("convenioId") Long convenioId) {
        return convenioMateriaRepository.findByConvenioId(convenioId);
    }

    public Page<ConvenioMateria> getPageConvenioMateriaByConvenioId(@PathVariable("convenioId")
                                                                                           Long convenioId, Pageable pageable) {
        return convenioMateriaRepository.findByConvenioId(convenioId, pageable);
    }

    public Optional<ConvenioMateria> findById(@PathVariable("id") Long id) {
        return convenioMateriaRepository.findById(id);
    }

    @Transactional
    public ConvenioMateria save(ConvenioMateria convenioMateria) {
        return convenioMateriaRepository.save(convenioMateria);
    }

    @Transactional
    public ConvenioMateria update(ConvenioMateria convenioMateria) {
        return convenioMateriaRepository.save(convenioMateria);
    }

    @Transactional
    public void delete(Long id) {
        convenioMateriaRepository.deleteById(id);
    }

}
