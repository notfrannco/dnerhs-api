package py.gov.mspbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import py.gov.mspbs.entity.Ciudad;
import py.gov.mspbs.repository.CiudadRepository;

@Service
@Transactional(readOnly = true)
public class CiudadService {

	@Autowired
	private CiudadRepository ciudadRepository;
	
	public List<Ciudad> findByIdDepartamento(Long idDepartamento) {
		return ciudadRepository.findByDepartamentoId(idDepartamento);
	}

}
