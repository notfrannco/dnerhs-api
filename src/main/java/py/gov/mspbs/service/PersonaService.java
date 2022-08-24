package py.gov.mspbs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import py.gov.mspbs.entity.Persona;
import py.gov.mspbs.repository.PersonaRepository;

@Service
@Transactional(readOnly = true)
public class PersonaService {

	@Autowired
	private PersonaRepository personaRepository;
	
	public List<Persona> findAll() {
		return personaRepository.findAll();
	}
	
	public Page<Persona> getPage(Pageable pageable) {
		return personaRepository.findAll(pageable);
	}
	
	public Optional<Persona> findById(@PathVariable("id") Long id) {
		return personaRepository.findById(id);
	}
	
	@Transactional
	public Persona save(Persona persona) {
		return personaRepository.save(persona);
	}
	
	@Transactional
	public Persona update(Persona persona) {
		return personaRepository.save(persona);
		
	}

	@Transactional
	public void delete(Long id) {
		personaRepository.deleteById(id);
	}

}
