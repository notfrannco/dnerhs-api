package py.gov.mspbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import py.gov.mspbs.entity.DatosEstablecimiento;
import py.gov.mspbs.entity.ProfesionalesSalud;
import py.gov.mspbs.repository.ProfesionalesSaludRepository;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class ProfesionalesSaludService {

    @Autowired
    private ProfesionalesSaludRepository profesionalesSaludRepository;

    public Optional<ProfesionalesSalud> findById(@PathVariable("id") Long id){
        return profesionalesSaludRepository.findById(id);
    }

    public Optional<ProfesionalesSalud> findByInstitucionEstablecimientoId(
            @PathVariable("establecimientoId") Long establecimientoId){
        return profesionalesSaludRepository.findByInstitucionEstablecimientoId(establecimientoId);
    }

    @Transactional
    public ProfesionalesSalud save(ProfesionalesSalud profesionalesSalud) {
        return profesionalesSaludRepository.save(profesionalesSalud);
    }

    @Transactional
    public ProfesionalesSalud update(ProfesionalesSalud profesionalesSalud) {
        return profesionalesSaludRepository.save(profesionalesSalud);
    }

    @Transactional
    public void delete(Long id) {
        profesionalesSaludRepository.deleteById(id);
    }

}
