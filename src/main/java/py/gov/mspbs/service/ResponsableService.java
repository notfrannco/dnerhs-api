package py.gov.mspbs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import py.gov.mspbs.entity.Responsable;
import py.gov.mspbs.entity.Usuario;
import py.gov.mspbs.repository.ResponsableRepository;

@Service
@Transactional(readOnly = true)
public class ResponsableService {

	@Autowired
	private ResponsableRepository responsableRepository;


//	public Responsable findResponsableByUsuario(Usuario usuario){
//		return responsableRepository.findResponsableByUsuario(usuario);
//	}
	
	public List<Responsable> findAll() {
		return responsableRepository.findAll();
	}
	
	public Page<Responsable> getPage(Pageable pageable) {
		return responsableRepository.findAll(pageable);
	}
	
	public Optional<Responsable> findById(@PathVariable("id") Long id) {
		return responsableRepository.findById(id);
	}
	
	@Transactional
	public Responsable save(Responsable responsable) {
		return responsableRepository.save(responsable);
	}
	
	@Transactional
	public Responsable update(Responsable responsable) {
		return responsableRepository.save(responsable);
		
	}

	@Transactional
	public void delete(Long id) {
		responsableRepository.deleteById(id);
	}

}
