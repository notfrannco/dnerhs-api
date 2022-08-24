package py.gov.mspbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import py.gov.mspbs.entity.Institucion;
import py.gov.mspbs.repository.InstitucionRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class InstitucionService {

    @Autowired
    InstitucionRepository institucionRepository;

    public List<Institucion> findAll() {
        return institucionRepository.findAll();
    }

    public Page<Institucion> getPage(Pageable pageable) {
        return institucionRepository.findAll(pageable);
    }

    public Optional<Institucion> findById(@PathVariable("id") Long id) {
        return institucionRepository.findById(id);
    }

    @Transactional
    public Institucion save(Institucion institucionFormadora) {
        return institucionRepository.save(institucionFormadora);
    }

    @Transactional
    public Institucion update(Institucion institucionFormadora) {
        return institucionRepository.save(institucionFormadora);

    }

    @Transactional
    public void delete(Long id) {
        institucionRepository.deleteById(id);
    }

}
