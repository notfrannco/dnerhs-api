package py.gov.mspbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import py.gov.mspbs.entity.Decano;
import py.gov.mspbs.repository.DecanoRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class DecanoService {

    @Autowired
    private DecanoRepository decanoRepository;

    public List<Decano> findAll() {
        return decanoRepository.findAll();
    }

    public Page<Decano> getPage(Pageable pageable) {
        return decanoRepository.findAll(pageable);
    }

    public Optional<Decano> findById(@PathVariable("id") Long id) {
        return decanoRepository.findById(id);
    }

    @Transactional
    public Decano save(Decano decano) {
        return decanoRepository.save(decano);
    }

    @Transactional
    public Decano update(Decano decano) {
        return decanoRepository.save(decano);
    }

    @Transactional
    public void delete(Long id) {
        decanoRepository.deleteById(id);
    }
}
