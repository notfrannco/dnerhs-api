package py.gov.mspbs.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import py.gov.mspbs.entity.ProfesionalesFormados;
import py.gov.mspbs.repository.ProfesionalesFormadosRepository;

@Service
@Transactional(readOnly = true)
public class ProfesionalesFormadosService {

    @Autowired
    private ProfesionalesFormadosRepository profesionalesFormadosRepository;

    public Optional<ProfesionalesFormados> findById(@PathVariable("id") Long id){
        return profesionalesFormadosRepository.findById(id);
    }

    public Optional<ProfesionalesFormados> findByConvenioId(@PathVariable("convenioId") Long convenioId){
        return profesionalesFormadosRepository.findByConvenioId(convenioId);
    }
    
    public Page<ProfesionalesFormados> getPageFindByConvenioId(@PathVariable("convenioId") Long convenioId, Pageable pageable) {
        return profesionalesFormadosRepository.findByConvenioId(convenioId, pageable);
    }

    @Transactional
    public ProfesionalesFormados save(ProfesionalesFormados profesionalesFormados){
        return profesionalesFormadosRepository.save(profesionalesFormados);
    }

    @Transactional
    public ProfesionalesFormados update(ProfesionalesFormados profesionalesFormados){
        return profesionalesFormadosRepository.save(profesionalesFormados);
    }

    @Transactional
    public void delete(Long id) {
        profesionalesFormadosRepository.deleteById(id);
    }

}
