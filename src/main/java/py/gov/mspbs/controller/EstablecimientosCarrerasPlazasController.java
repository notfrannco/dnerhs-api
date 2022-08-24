package py.gov.mspbs.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import py.gov.mspbs.entity.EstablecimientosCarrerasPlazas;
import py.gov.mspbs.repository.EstablecimientosCarrerasPlazasObservacionesRepository;
import py.gov.mspbs.service.EstablecimientosCarrerasPlazasObservacionesService;
import py.gov.mspbs.service.EstablecimientosCarrerasPlazasService;

@RestController
@RequestMapping(value = "/establecimientos-carreras-plazas", produces = MediaType.APPLICATION_JSON_VALUE)
public class EstablecimientosCarrerasPlazasController {

	@Autowired
	EstablecimientosCarrerasPlazasService establecimientosCarrerasPlazasService;

	@Autowired
	EstablecimientosCarrerasPlazasObservacionesService establecimientosCarrerasPlazasObservacionesService;

	@Autowired
	EstablecimientosCarrerasPlazasObservacionesRepository establecimientosCarrerasPlazasObservacionesRepository;

	@ApiOperation(value = "Listar establecimientos carreras plazas", notes = "Lista de establecimientos carreras plazas registrados o vacio si no hay registros")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Lista de establecimientos carreras plazas"), })
	@GetMapping
	public List<EstablecimientosCarrerasPlazas> findAll() {
		return establecimientosCarrerasPlazasService.findAll();
	}

	@ApiOperation(value = "Listar carreras de un servicio", notes = "Lista de carreras registradas de un servicio o vacio si no hay registros")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Lista de carreras del servicio"), })
	@GetMapping("{id}/carreras")
	List<EstablecimientosCarrerasPlazas> findCarrerasByIdNombreServicio(
			@ApiParam("ID Nombre Servicio") @PathVariable("id") Long id) {
		return establecimientosCarrerasPlazasService.findByIdNombreServicio(id);
	}

	/*
	@ApiOperation(value = "Actualizar establecimientos carreras plazas", notes = "Actualiza los datos de un establecimiento carrera plaza")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Establecimiento carrera plaza Actualizado"), })
	@PatchMapping("{id}")
	public ResponseEntity<EstablecimientosCarrerasPlazas> update(@PathVariable("id") Long id,
			@RequestBody Map<Object, Object> fields) {
		Optional<EstablecimientosCarrerasPlazas> establecimientosCarrerasPlazas = establecimientosCarrerasPlazasService
				.findById(id);
		if (establecimientosCarrerasPlazas.isPresent()) {
			fields.forEach((key, value) -> {

				Field field = ReflectionUtils.findRequiredField(EstablecimientosCarrerasPlazas.class, (String) key);
				field.setAccessible(true);
				ReflectionUtils.setField(field, establecimientosCarrerasPlazas.get(), value);
				if (key.equals("observacion")) {
					EstablecimientosCarrerasPlazasObservaciones establecimientoCarreraPlazaObservacion = new EstablecimientosCarrerasPlazasObservaciones();
					EstablecimientosCarrerasPlazas establecimientoCarreraPlaza = new EstablecimientosCarrerasPlazas();
					establecimientoCarreraPlaza.setId(id);
					establecimientoCarreraPlazaObservacion.setEstablecimientoCarreraPlaza(establecimientoCarreraPlaza);
					establecimientoCarreraPlazaObservacion.setFechaObservacion(new Date());
					establecimientoCarreraPlazaObservacion.setObservacion(establecimientosCarrerasPlazas.get().getObservacion());
					establecimientosCarrerasPlazasObservacionesRepository.save(establecimientoCarreraPlazaObservacion);
				}
			});
			EstablecimientosCarrerasPlazas updatedEstablecimientosCarrerasPlazas = establecimientosCarrerasPlazasService
					.update(establecimientosCarrerasPlazas.get());
			return new ResponseEntity<>(updatedEstablecimientosCarrerasPlazas, HttpStatus.OK);
		}

		return null;
	}
	 */
	@ApiOperation(value = "Actualizar cantidad de establecimiento Carrera Plaza", notes = "Actualiza los datos de un establecimiento carrera plaza")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Establecimiento carrera plaza Actualizado"), })
	@PutMapping("{id}/cantidad")
	public EstablecimientosCarrerasPlazas updateCantidad(
		@ApiParam("ID Establecimiento Carrera Plaza") @PathVariable("id") Long id,
		@ApiParam("cantidad") @RequestParam(value = "cantidad", defaultValue = "0", required = true) Integer cantidad,
		@ApiParam("Observación") @RequestParam(value = "observacion", defaultValue = "", required = false) String observacion) {
		return establecimientosCarrerasPlazasService.updateCantidad(id, cantidad, observacion);
	}

}
