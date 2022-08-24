package py.gov.mspbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import py.gov.mspbs.entity.ResponsableEstablecimiento;
import py.gov.mspbs.repository.ResponsableEstablecimientoRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class ResponsableEstablecimientoService {

    @Autowired
    private ResponsableEstablecimientoRepository responsableEstablecimientoRepository;

    public List<ResponsableEstablecimiento> findAll() {
        return responsableEstablecimientoRepository.findAll();
    };

    public Optional<ResponsableEstablecimiento> findById(@PathVariable("id") Long id) {
        return responsableEstablecimientoRepository.findById(id);
    }

    public List<ResponsableEstablecimiento> findByCedulaIdentidad(@PathVariable("cedula") Integer cedula) {
        return responsableEstablecimientoRepository.findByCedulaIdentidad(cedula);
    }

    @Transactional
    public ResponsableEstablecimiento save(ResponsableEstablecimiento responsable) {
        return responsableEstablecimientoRepository.save(responsable);
    }

    @Transactional
    public ResponsableEstablecimiento update(ResponsableEstablecimiento responsable) {
        return responsableEstablecimientoRepository.save(responsable);

    }

    @Transactional
    public void delete(Long id) {
        responsableEstablecimientoRepository.deleteById(id);
    }
}
