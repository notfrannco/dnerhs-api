package py.gov.mspbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import py.gov.mspbs.entity.ConvenioDocumentosRespaldo;
import py.gov.mspbs.repository.ConvenioDocumentosRespaldoRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class ConvenioDocumentosRespaldoService {

    @Autowired
    private ConvenioDocumentosRespaldoRepository convenioDocumentosRespaldoRepository;

    public ConvenioDocumentosRespaldo findByConvenioId(@PathVariable("convenioId") Long convenioId) {
        return convenioDocumentosRespaldoRepository.findByConvenioId(convenioId);
    }

    public Optional<ConvenioDocumentosRespaldo> findById(@PathVariable("id") Long id) {
        return convenioDocumentosRespaldoRepository.findById(id);
    }

    @Transactional
    public ConvenioDocumentosRespaldo save(ConvenioDocumentosRespaldo convenioDocumentosRespaldo) {
        return convenioDocumentosRespaldoRepository.save(convenioDocumentosRespaldo);
    }

    @Transactional
    public ConvenioDocumentosRespaldo update(ConvenioDocumentosRespaldo convenioDocumentosRespaldo) {
        return convenioDocumentosRespaldoRepository.save(convenioDocumentosRespaldo);

    }

    @Transactional
    public void delete(Long id) {
        convenioDocumentosRespaldoRepository.deleteById(id);
    }


}
