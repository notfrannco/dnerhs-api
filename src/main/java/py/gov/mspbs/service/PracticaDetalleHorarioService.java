package py.gov.mspbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import py.gov.mspbs.entity.PracticaDetalleHorario;
import py.gov.mspbs.repository.PracticaDetalleHorarioRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PracticaDetalleHorarioService {

    @Autowired
    private PracticaDetalleHorarioRepository practicaDetalleHorarioRepository;


    public List<PracticaDetalleHorario> findAll() {
        return practicaDetalleHorarioRepository.findAll();
    }

    public Optional<PracticaDetalleHorario> findById(@PathVariable("id") Long id) {
        return practicaDetalleHorarioRepository.findById(id);
    }

    public List<PracticaDetalleHorario> findByPracticaDetalleId(@PathVariable("id") Long id) {
        return practicaDetalleHorarioRepository.findByPracticaDetalleId(id);
    }

    @Transactional
    public PracticaDetalleHorario save(PracticaDetalleHorario practicaDetalleHorario) {
        return practicaDetalleHorarioRepository.save(practicaDetalleHorario);
    }

    @Transactional
    public PracticaDetalleHorario update(PracticaDetalleHorario practicaDetalleHorario) {
        return practicaDetalleHorarioRepository.save(practicaDetalleHorario);

    }

    @Transactional
    public void delete(Long id) {
        practicaDetalleHorarioRepository.deleteById(id);
    }
}
