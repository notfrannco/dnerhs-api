package py.gov.mspbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import py.gov.mspbs.entity.InstitucionFormadoraResponsableMaximaAutoridad;
import py.gov.mspbs.repository.InstitucionFormadoraResponsableMaximaAutoridadRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class InstitucionFormadoraResponsableMaximaAutoridadService {

	@Autowired
	private InstitucionFormadoraResponsableMaximaAutoridadRepository institucionFormadoraResponsableRepository;
	
	public List<InstitucionFormadoraResponsableMaximaAutoridad> findAll() {
		return institucionFormadoraResponsableRepository.findAll();
	}
	
	public Page<InstitucionFormadoraResponsableMaximaAutoridad> getPageInstitucionFormadoraResponsableByEstado(String estado, Pageable pageable) {
		return institucionFormadoraResponsableRepository.findInstitucionFormadoraResponsableByEstado(estado, pageable);
	}

	public List<InstitucionFormadoraResponsableMaximaAutoridad> findInstitucionFormadoraResponsableByEstado(String estado) {
		return institucionFormadoraResponsableRepository.findInstitucionFormadoraResponsableByEstado(estado);
	}

	public Page<InstitucionFormadoraResponsableMaximaAutoridad> getPage(Pageable pageable) {
		return institucionFormadoraResponsableRepository.findAll(pageable);
	}
	
	public Optional<InstitucionFormadoraResponsableMaximaAutoridad> findById(@PathVariable("id") Long id) {
		return institucionFormadoraResponsableRepository.findById(id);
	}

	public InstitucionFormadoraResponsableMaximaAutoridad findInstitucionFormadoraResponsableByResponsableId(Long responsableId){
		return institucionFormadoraResponsableRepository.findInstitucionFormadoraResponsableByResponsableId(responsableId);
	}


	@Transactional
	public InstitucionFormadoraResponsableMaximaAutoridad save(InstitucionFormadoraResponsableMaximaAutoridad institucionFormadoraResponsable) {
		return institucionFormadoraResponsableRepository.save(institucionFormadoraResponsable);
	}
	
	@Transactional
	public InstitucionFormadoraResponsableMaximaAutoridad update(InstitucionFormadoraResponsableMaximaAutoridad institucionFormadoraResponsable) {
		return institucionFormadoraResponsableRepository.save(institucionFormadoraResponsable);
		
	}

	@Transactional
	public void delete(Long id) {
		institucionFormadoraResponsableRepository.deleteById(id);
	}

	public InstitucionFormadoraResponsableMaximaAutoridad findbyFormadoraId(Long formadoraId){
		return institucionFormadoraResponsableRepository.findByFormadoraId(formadoraId);
	}

}
