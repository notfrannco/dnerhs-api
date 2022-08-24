package py.gov.mspbs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import py.gov.mspbs.entity.InstitucionEstablecimiento;
import py.gov.mspbs.repository.InstitucionEstablecimientoRepository;

@Service
@Transactional(readOnly = true)
public class InstitucionEstablecimientoService {

	@Autowired
	private InstitucionEstablecimientoRepository institucionRepository;
	
	public List<InstitucionEstablecimiento> findAll() {
		return institucionRepository.findAll();
	}
	
	public Page<InstitucionEstablecimiento> getPage(Pageable pageable) {
		return institucionRepository.findAll(pageable);
	}
	
	public Optional<InstitucionEstablecimiento> findById(@PathVariable("id") Long id) {
		return institucionRepository.findById(id);
	}
	
	@Transactional
	public InstitucionEstablecimiento save(InstitucionEstablecimiento institucionEstablecimiento) {
		return institucionRepository.save(institucionEstablecimiento);
	}
	
	@Transactional
	public InstitucionEstablecimiento update(InstitucionEstablecimiento institucionEstablecimiento) {
		return institucionRepository.save(institucionEstablecimiento);
		
	}

	@Transactional
	public void delete(Long id) {
		institucionRepository.deleteById(id);
	}

}
