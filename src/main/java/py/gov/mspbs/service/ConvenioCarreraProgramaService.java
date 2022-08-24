package py.gov.mspbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import py.gov.mspbs.entity.Convenio;
import py.gov.mspbs.entity.ConvenioCarreraPrograma;
import py.gov.mspbs.entity.ConvenioEstudiante;
import py.gov.mspbs.repository.ConvenioCarreraProgramaRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class ConvenioCarreraProgramaService {

    @Autowired
    private ConvenioCarreraProgramaRepository convenioCarreraProgramaRepository;

    public List<ConvenioCarreraPrograma> findByConvenioId(@PathVariable("convenioId") Long convenioId) {
        return convenioCarreraProgramaRepository.findByConvenioId(convenioId);
    }
    
    public Page<ConvenioCarreraPrograma> getPageFindByConvenioId(@PathVariable("convenioId") Long convenioId, Pageable pageable) {
        return convenioCarreraProgramaRepository.findByConvenioId(convenioId, pageable);
    }

    public Page<ConvenioCarreraPrograma> getPage(Pageable pageable) {
        return convenioCarreraProgramaRepository.findAll(pageable);
    }

    public Optional<ConvenioCarreraPrograma> findById(@PathVariable("id") Long id) {
        return convenioCarreraProgramaRepository.findById(id);
    }

    @Transactional
    public ConvenioCarreraPrograma save(ConvenioCarreraPrograma convenioCarreraPrograma) {
        return convenioCarreraProgramaRepository.save(convenioCarreraPrograma);
    }

    @Transactional
    public ConvenioCarreraPrograma update(ConvenioCarreraPrograma convenioCarreraPrograma) {
        return convenioCarreraProgramaRepository.save(convenioCarreraPrograma);
    }

    @Transactional
    public void delete(Long id) {
        convenioCarreraProgramaRepository.deleteById(id);
    }

    public List<ConvenioCarreraPrograma> findByCarreraProgramaId(Long carreraId){
        return convenioCarreraProgramaRepository.findByCarreraProgramaId(carreraId);
    }
    
}
