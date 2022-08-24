package py.gov.mspbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import py.gov.mspbs.entity.IngresosEgresos;
import py.gov.mspbs.repository.IngresosEgresosRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class IngresosEgresosService {

    @Autowired
    private IngresosEgresosRepository ingresosEgresosRepository;

    public Optional<IngresosEgresos> findById(@PathVariable("id") Long id) {
        return ingresosEgresosRepository.findById(id);
    }

    @Transactional
    public IngresosEgresos save(IngresosEgresos ingresosEgresos) {
        return ingresosEgresosRepository.save(ingresosEgresos);
    }

    @Transactional
    public IngresosEgresos update(IngresosEgresos ingresosEgresos) {
        return ingresosEgresosRepository.save(ingresosEgresos);

    }

    @Transactional
    public void delete(Long id) {
        ingresosEgresosRepository.deleteById(id);
    }

}
