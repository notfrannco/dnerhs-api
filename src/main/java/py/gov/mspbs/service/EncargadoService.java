package py.gov.mspbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import py.gov.mspbs.entity.Encargado;
import py.gov.mspbs.repository.EncargadoRepository;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class EncargadoService {

    @Autowired
    private EncargadoRepository encargadoRepository;

    public Optional<Encargado> findById(@PathVariable("id") Long id){
        return encargadoRepository.findById(id);
    }

    public Optional<Encargado> findByInstitucionEstablecimientoId(
            @PathVariable("establecimientoId") Long establecimientoId){
        return encargadoRepository.findByInstitucionEstablecimientoId(establecimientoId);
    }

    @Transactional
    public Encargado save(Encargado encargado) {
        return encargadoRepository.save(encargado);
    }

    @Transactional
    public Encargado update(Encargado encargado) {
        return encargadoRepository.save(encargado);
    }

    @Transactional
    public void delete(Long id) {
        encargadoRepository.deleteById(id);
    }

}
