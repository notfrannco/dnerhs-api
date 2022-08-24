package py.gov.mspbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import py.gov.mspbs.entity.IngresosEgresos;
import py.gov.mspbs.entity.Tutor;
import py.gov.mspbs.repository.TutorRepository;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class TutorService {

    @Autowired
    private TutorRepository tutorRepository;

    public Optional<Tutor> findById(@PathVariable("id") Long id) {
        return tutorRepository.findById(id);
    }

    @Transactional
    public Tutor save(Tutor tutor) {
        return tutorRepository.save(tutor);
    }

    @Transactional
    public Tutor update(Tutor tutor) {
        return tutorRepository.save(tutor);
    }

    @Transactional
    public void delete(Long id) {
        tutorRepository.deleteById(id);
    }
}
