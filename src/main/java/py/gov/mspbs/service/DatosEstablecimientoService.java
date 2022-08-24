package py.gov.mspbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import py.gov.mspbs.entity.DatosEstablecimiento;
import py.gov.mspbs.repository.DatosEstablecimientoRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class DatosEstablecimientoService {

    @Autowired
    private DatosEstablecimientoRepository datosEstablecimientoRepository;

    public Optional<DatosEstablecimiento> findById(@PathVariable("id") Long id){
        return datosEstablecimientoRepository.findById(id);
    }

    public Optional<DatosEstablecimiento> findByInstitucionEstablecimientoId(
            @PathVariable("establecimientoId") Long establecimientoId){
        return datosEstablecimientoRepository.findByInstitucionEstablecimientoId(establecimientoId);
    }

    public List<DatosEstablecimiento> findByRegionSanitariaId(
            @PathVariable("regionSanitariaId") Long regionSanitariaId){
        return datosEstablecimientoRepository.findByRegionSanitariaId(regionSanitariaId);
    }

    @Transactional
    public DatosEstablecimiento save(DatosEstablecimiento datosEstablecimiento) {
        return datosEstablecimientoRepository.save(datosEstablecimiento);
    }

    @Transactional
    public DatosEstablecimiento update(DatosEstablecimiento datosEstablecimiento) {
        return datosEstablecimientoRepository.save(datosEstablecimiento);
    }

    @Transactional
    public void delete(Long id) {
        datosEstablecimientoRepository.deleteById(id);
    }

}
