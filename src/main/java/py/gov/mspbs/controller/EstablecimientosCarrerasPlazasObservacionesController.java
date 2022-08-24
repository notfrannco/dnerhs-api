package py.gov.mspbs.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import py.gov.mspbs.entity.EstablecimientosCarrerasPlazasObservaciones;
import py.gov.mspbs.service.EstablecimientosCarrerasPlazasObservacionesService;

@RestController
@RequestMapping(value = "/establecimientos-carreras-plazas-observaciones", produces = MediaType.APPLICATION_JSON_VALUE)
public class EstablecimientosCarrerasPlazasObservacionesController {

	@Autowired
	EstablecimientosCarrerasPlazasObservacionesService establecimientosCarrerasPlazasObservacionesService;

	@ApiOperation(value = "Listar observaciones de establecimiento carrera plaza", notes = "Lista de observaciones de establecimiento carrera plaza registrados o vacio si no hay registros")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Lista de observaciones de establecimientos carreras plazas"), })
	@GetMapping
	public List<EstablecimientosCarrerasPlazasObservaciones> findAll() {
		return establecimientosCarrerasPlazasObservacionesService.findAll();
	}

	@ApiOperation(value = "Listar observaciones de un establecimiento carrera plaza", notes = "Lista de observaciones registradas de un establecimiento carrera plaza o vacio si no hay registros")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Lista de observaciones del establecimiento carrera plaza"), })
	@GetMapping("{id}/observaciones")
	List<EstablecimientosCarrerasPlazasObservaciones> findObservacionesByIdEstablecimientoCarreraPlaza(@ApiParam("ID Establecimiento Carrera Plaza") @PathVariable("id") Long id) {
		return establecimientosCarrerasPlazasObservacionesService.findByIdEstablecimientoCarrerarPlaza(id);
	}

	@ApiOperation(value = "Crea una nueva observacion para establecimientos carreras plazas", notes = "Crea una nueva observacion para un establecimiento carrera plaza")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Establecimiento carrera plaza observaciones Agregado"), })
	@PostMapping
	public EstablecimientosCarrerasPlazasObservaciones save(@ApiParam("Establecimiento Carrera Plaza Observacion") @RequestBody @Valid EstablecimientosCarrerasPlazasObservaciones establecimientosCarrerasPlazasObservaciones) {
		return establecimientosCarrerasPlazasObservacionesService.save(establecimientosCarrerasPlazasObservaciones);
	}

}
