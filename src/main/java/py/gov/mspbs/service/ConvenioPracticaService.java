package py.gov.mspbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import py.gov.mspbs.constants.EstadoPractica;
import py.gov.mspbs.entity.*;
import py.gov.mspbs.repository.ConvenioPracticaRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class ConvenioPracticaService {

    @Autowired
    ConvenioPracticaRepository convenioPracticaRepository;

    public List<Practica> findAll() {
        return convenioPracticaRepository.findAll();
    }

    public Optional<Practica> findById(@PathVariable("id") Long id) {
        return convenioPracticaRepository.findById(id);
    }

    public List<Practica> findByConvenioId(Long convenioId) {
        return convenioPracticaRepository.findByConvenioId(convenioId);
    }
    
    public Page<Practica> getPageFindByConvenioId(@PathVariable("convenioId") Long convenioId, Pageable pageable) {
        return convenioPracticaRepository.findByConvenioId(convenioId, pageable);
    }
    
	public Page<Practica> getPracticasAprobadasPageByConvenioId(Long convenioId, Pageable pageable) {
		List<String> listEstadosAprobados = Arrays.asList(EstadoPractica.PRACTICA_APROBADA,
				EstadoPractica.PRACTICA_MODIFICACIONES_APROBADA);
		return convenioPracticaRepository.findByConvenioIdAndEstadoIn(convenioId, listEstadosAprobados, pageable);
	}

    @Transactional
    public Practica save(Practica practica) {
        return convenioPracticaRepository.save(practica);
    }

    @Transactional
    public Practica update(Practica practica) {
        return convenioPracticaRepository.save(practica);

    }

    @Transactional
    public void delete(Long id) {
        convenioPracticaRepository.deleteById(id);
    }

}
