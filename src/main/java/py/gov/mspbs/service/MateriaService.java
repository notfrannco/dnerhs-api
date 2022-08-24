package py.gov.mspbs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import py.gov.mspbs.entity.Materia;
import py.gov.mspbs.repository.MateriaRepository;

@Service
@Transactional(readOnly = true)
public class MateriaService {

	@Autowired
	private MateriaRepository materiaRepository;
	
	public List<Materia> findAll() {
		return materiaRepository.findAll();
	}
	
	public Page<Materia> getPage(Pageable pageable) {
		return materiaRepository.findAll(pageable);
	}
	
	public Optional<Materia> findById(@PathVariable("id") Long id) {
		return materiaRepository.findById(id);
	}
	
	@Transactional
	public Materia save(Materia materia) {
		return materiaRepository.save(materia);
	}
	
	@Transactional
	public Materia update(Materia materia) {
		return materiaRepository.save(materia);
		
	}

	@Transactional
	public void delete(Long id) {
		materiaRepository.deleteById(id);
	}

}
