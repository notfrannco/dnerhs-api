package py.gov.mspbs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import py.gov.mspbs.entity.EstablecimientosCarrerasPlazasObservaciones;
import py.gov.mspbs.repository.EstablecimientosCarrerasPlazasObservacionesRepository;

@Service
@Transactional(readOnly = true)
public class EstablecimientosCarrerasPlazasObservacionesService {

	@Autowired
	private EstablecimientosCarrerasPlazasObservacionesRepository establecimientosCarrerasPlazasObservacionesRepository;
	
	public List<EstablecimientosCarrerasPlazasObservaciones> findAll() {
		return establecimientosCarrerasPlazasObservacionesRepository.findAll();
	}

	public Optional<EstablecimientosCarrerasPlazasObservaciones> findById(Long id) {
		return establecimientosCarrerasPlazasObservacionesRepository.findById(id);
	}
	
	public List<EstablecimientosCarrerasPlazasObservaciones> findByIdEstablecimientoCarrerarPlaza(Long idEstablecimientoCarreraPlaza) {
		return establecimientosCarrerasPlazasObservacionesRepository.findByEstablecimientoCarreraPlazaId(idEstablecimientoCarreraPlaza);
	}

	@Transactional
	public EstablecimientosCarrerasPlazasObservaciones save(EstablecimientosCarrerasPlazasObservaciones establecimientosCarrerasPlazasObservaciones) {
		return establecimientosCarrerasPlazasObservacionesRepository.save(establecimientosCarrerasPlazasObservaciones);
	}

}
