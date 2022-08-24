package py.gov.mspbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import py.gov.mspbs.entity.Departamento;
import py.gov.mspbs.repository.DepartamentoRepository;

@Service
@Transactional(readOnly = true)
public class DepartamentoService {

	@Autowired
	private DepartamentoRepository departamentoRepository;
	
	public List<Departamento> findAll() {
		return departamentoRepository.findAll();
	}

}
