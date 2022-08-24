package py.gov.mspbs.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import py.gov.mspbs.entity.EstablecimientosCarrerasPlazas;
import py.gov.mspbs.entity.EstablecimientosCarrerasPlazasObservaciones;
import py.gov.mspbs.repository.EstablecimientosCarrerasPlazasObservacionesRepository;
import py.gov.mspbs.repository.EstablecimientosCarrerasPlazasRepository;

@Service
@Transactional(readOnly = true)
public class EstablecimientosCarrerasPlazasService {

	@Autowired
	private EstablecimientosCarrerasPlazasRepository establecimientosCarrerasPlazasRepository;

	@Autowired
	private EstablecimientosCarrerasPlazasObservacionesRepository establecimientosCarrerasPlazasObservacionesRepository;

	public List<EstablecimientosCarrerasPlazas> findAll() {
		return establecimientosCarrerasPlazasRepository.findAll();
	}

	public Optional<EstablecimientosCarrerasPlazas> findById(Long id) {
		return establecimientosCarrerasPlazasRepository.findById(id);
	}

	public Optional<EstablecimientosCarrerasPlazas> findByNombreServicioIdAndCarreraprogramaId(Long idNombreServicio,
			Long idCarreraprograma) {
		return establecimientosCarrerasPlazasRepository.findByNombreServicioIdAndCarreraprogramaId(idNombreServicio,
				idCarreraprograma);
	}

	public List<EstablecimientosCarrerasPlazas> findByIdNombreServicio(Long idNombreServicio) {
		return establecimientosCarrerasPlazasRepository.findByNombreServicioId(idNombreServicio);
	}

	@Transactional
	public EstablecimientosCarrerasPlazas update(EstablecimientosCarrerasPlazas establecimientosCarrerasPlazas) {
		return establecimientosCarrerasPlazasRepository.save(establecimientosCarrerasPlazas);

	}

	@Transactional
	public EstablecimientosCarrerasPlazas updateCantidad(Long id, Integer cantidad, String observacion) {
		System.out.println("id y operacion -> " + id + " - " + cantidad + " - " + observacion);

		EstablecimientosCarrerasPlazas establecimientoCarreraPlaza = establecimientosCarrerasPlazasRepository.findById(id)
				.get();
		Integer cantidadAnterior = establecimientoCarreraPlaza.getCantidad();
		Integer cantidadDisponible = establecimientoCarreraPlaza.getDisponible();
		Integer diferencia = cantidad - cantidadAnterior;
		Integer disponible = cantidadDisponible + diferencia;

		establecimientoCarreraPlaza.setCantidad(cantidad);
		establecimientoCarreraPlaza.setDisponible(disponible);

		EstablecimientosCarrerasPlazasObservaciones establecimientoCarreraPlazaObservacion = new EstablecimientosCarrerasPlazasObservaciones();
		establecimientoCarreraPlazaObservacion.setEstablecimientoCarreraPlaza(establecimientoCarreraPlaza);
		establecimientoCarreraPlazaObservacion.setFechaObservacion(new Date());
		establecimientoCarreraPlazaObservacion.setObservacion(observacion);
		establecimientosCarrerasPlazasObservacionesRepository.save(establecimientoCarreraPlazaObservacion);

		return establecimientoCarreraPlaza;
	}

}
