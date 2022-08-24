package py.gov.mspbs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import py.gov.mspbs.entity.Docente;
import py.gov.mspbs.repository.DocenteRepository;

@Service
@Transactional(readOnly = true)
public class DocenteService {

	@Autowired
	private DocenteRepository docenteRepository;
	
	public List<Docente> findAll() {
		return docenteRepository.findAll();
	}
	
	public Page<Docente> getPage(Pageable pageable) {
		return docenteRepository.findAll(pageable);
	}
	
	public Optional<Docente> findById(@PathVariable("id") Long id) {
		return docenteRepository.findById(id);
	}
	
	@Transactional
	public Docente save(Docente docente) {
		return docenteRepository.save(docente);
	}
	
	@Transactional
	public Docente update(Docente docente) {
		return docenteRepository.save(docente);
		
	}

	@Transactional
	public void delete(Long id) {
		docenteRepository.deleteById(id);
	}

}
