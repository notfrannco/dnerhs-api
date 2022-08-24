package py.gov.mspbs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import py.gov.mspbs.entity.Nacionalidad;
import py.gov.mspbs.repository.NacionalidadRepository;

@Service
@Transactional(readOnly = true)
public class NacionalidadService {

	@Autowired
	private NacionalidadRepository nacionalidadRepository;
	
	public List<Nacionalidad> findAll() {
		return nacionalidadRepository.findAll();
	}
	
	public Page<Nacionalidad> getPage(Pageable pageable) {
		return nacionalidadRepository.findAll(pageable);
	}
	
	public Optional<Nacionalidad> findById(@PathVariable("id") Long id) {
		return nacionalidadRepository.findById(id);
	}
	
	@Transactional
	public Nacionalidad save(Nacionalidad nacionalidad) {
		return nacionalidadRepository.save(nacionalidad);
	}
	
	@Transactional
	public Nacionalidad update(Nacionalidad nacionalidad) {
		return nacionalidadRepository.save(nacionalidad);
		
	}

	@Transactional
	public void delete(Long id) {
		nacionalidadRepository.deleteById(id);
	}

}
