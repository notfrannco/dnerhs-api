package py.gov.mspbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import py.gov.mspbs.entity.TipoEstablecimiento;
import py.gov.mspbs.repository.TipoEstablecimientoRepository;

@Service
@Transactional(readOnly = true)
public class TipoEstablecimientoService {

	@Autowired
	private TipoEstablecimientoRepository tipoEstablecimientoRepository;
	
	public List<TipoEstablecimiento> findAll() {
		return tipoEstablecimientoRepository.findAll();
	}

}
