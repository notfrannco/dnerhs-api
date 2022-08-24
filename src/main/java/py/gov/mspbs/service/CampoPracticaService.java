package py.gov.mspbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import py.gov.mspbs.entity.CampoPractica;
import py.gov.mspbs.repository.CampoPracticaRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class CampoPracticaService {

    @Autowired
    private CampoPracticaRepository campoPracticaRepository;

    public List<CampoPractica> findAll() {
        return campoPracticaRepository.findAll();
    }

    public Page<CampoPractica> getPage(Pageable pageable) {
        return campoPracticaRepository.findAll(pageable);
    }

    public Optional<CampoPractica> findById(@PathVariable("id") Long id) {
        return campoPracticaRepository.findById(id);
    }

    @Transactional
    public CampoPractica save(CampoPractica campoPractica) {
        return campoPracticaRepository.save(campoPractica);
    }

    @Transactional
    public CampoPractica update(CampoPractica campoPractica) {
        return campoPracticaRepository.save(campoPractica);

    }

    @Transactional
    public void delete(Long id) {
        campoPracticaRepository.deleteById(id);
    }
}
