package py.gov.mspbs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import py.gov.mspbs.entity.Autoridad;
import py.gov.mspbs.repository.AutoridadRepository;

@Service
@Transactional(readOnly = true)
public class AutoridadService {

	@Autowired
	private AutoridadRepository encargadoRepository;
	
	public List<Autoridad> findAll() {
		return encargadoRepository.findAll();
	}
	
	public Page<Autoridad> getPage(Pageable pageable) {
		return encargadoRepository.findAll(pageable);
	}
	
	public Optional<Autoridad> findById(@PathVariable("id") Long id) {
		return encargadoRepository.findById(id);
	}
	
	@Transactional
	public Autoridad save(Autoridad autoridad) {
		return encargadoRepository.save(autoridad);
	}
	
	@Transactional
	public Autoridad update(Autoridad autoridad) {
		return encargadoRepository.save(autoridad);
		
	}

	@Transactional
	public void delete(Long id) {
		encargadoRepository.deleteById(id);
	}

}
