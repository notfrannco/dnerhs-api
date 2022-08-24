package py.gov.mspbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import py.gov.mspbs.entity.TipoInstitucion;
import py.gov.mspbs.repository.TipoInstitucionRepository;

@Service
@Transactional(readOnly = true)
public class TipoInstitucionService {

	@Autowired
	private TipoInstitucionRepository tipoInstitucionRepository;
	
	public List<TipoInstitucion> findAll() {
		return tipoInstitucionRepository.findAll();
	}

}
