package py.gov.mspbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import py.gov.mspbs.entity.ConvenioIngresosEgresos;
import py.gov.mspbs.repository.ConvenioIngresosEgresosRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class ConvenioIngresosEgresosService {

    @Autowired
    ConvenioIngresosEgresosRepository convenioIngresosEgresosRepository;

    public List<ConvenioIngresosEgresos> findByConvenioId(@PathVariable("convenioId") Long convenioId) {
        return convenioIngresosEgresosRepository.findByConvenioId(convenioId);
    }

    public Optional<ConvenioIngresosEgresos> findById(@PathVariable("id") Long id) {
        return convenioIngresosEgresosRepository.findById(id);
    }

    @Transactional
    public ConvenioIngresosEgresos save(ConvenioIngresosEgresos convenioIngresosEgresos) {
        return convenioIngresosEgresosRepository.save(convenioIngresosEgresos);
    }

    @Transactional
    public ConvenioIngresosEgresos update(ConvenioIngresosEgresos convenioIngresosEgresos) {
        return convenioIngresosEgresosRepository.save(convenioIngresosEgresos);

    }

    @Transactional
    public void delete(Long id) {
        convenioIngresosEgresosRepository.deleteById(id);
    }

}
