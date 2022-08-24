package py.gov.mspbs.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import py.gov.mspbs.entity.SolicitudPlazaObservacion;
import py.gov.mspbs.service.SolicitudPlazaObservacionService;

@RestController
@RequestMapping(value = "/solicitudes-plazas-observaciones", produces = MediaType.APPLICATION_JSON_VALUE)
public class SolicitudPlazaObservacionController {

	@Autowired
	SolicitudPlazaObservacionService solicitudPlazaObservacionService;

	@ApiOperation(value = "Listar campos de solicitud de plazas observaciones", notes = "Lista de campos de solicitudes de plazas observaciones, vacío si no hay registros")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Lista de campos de solicitudes de plazas observaciones"), })
	@GetMapping
	public List<SolicitudPlazaObservacion> findAll() {
		return solicitudPlazaObservacionService.findAll();
	}

	@ApiOperation(value = "Obtener solicitud plaza observacion por ID", notes = "Retorna una solicitud plaza observacion dada su ID")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Solicitud Plaza Observacion"),
			@ApiResponse(code = 404, message = "No se encontró solicitud plaza observacion") })
	@GetMapping("{id}")
	public Optional<SolicitudPlazaObservacion> findById(@ApiParam("ID Solicitud Plaza Observacion") @PathVariable("id") Long id) {
		return solicitudPlazaObservacionService.findById(id);
	}

	@ApiOperation(value = "Obtener solicitud plaza observacion por Solicitud de plaza ID", notes = "Retorna una lista de solicitudes plazas observaciones dada el ID de solicitudes de plaza")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Solicitudes de Plazas Observaciones por Solicitud de Plaza ID"),
			@ApiResponse(code = 404, message = "No se encontró solicitudes plazas observaciones para esa Solicitud de Plaza ID") })
	@GetMapping("{id}/observaciones")
	public List<SolicitudPlazaObservacion> findByIdSolicitudPlaza(@ApiParam("ID Solicitud Plaza") @PathVariable("id") Long id) {
		return solicitudPlazaObservacionService.findBySolicitudPlazaId(id);
	}

	@ApiOperation(value = "Crear solicitud plaza observacion", notes = "Guarda los datos de una nueva solicitud de plaza observacion")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Nueva Solicitud de plaza observacion"), })
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public SolicitudPlazaObservacion save(@ApiParam("Nueva Solicitud Plaza Observacion") @RequestBody @Valid SolicitudPlazaObservacion solicitudPlazaObservacion) {
		return solicitudPlazaObservacionService.save(solicitudPlazaObservacion);
	}

	@ApiOperation(value = "Actualizar solicitud de plaza observacion", notes = "Actualiza los datos de una solicitud de plaza observacion")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Solicitud de plaza observacion Actualizado"), })
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public SolicitudPlazaObservacion update(@ApiParam("Solicitud de plaza observacion") @RequestBody @Valid SolicitudPlazaObservacion solicitudPlazaObservacion) {
		return solicitudPlazaObservacionService.update(solicitudPlazaObservacion);
	}

	@ApiOperation(value = "Eliminar solicitud de plaza observacion", notes = "Elimina los datos de una solicitud de plaza observacion")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Solicitud de plaza observacion Eliminado"), })
	public @DeleteMapping("{id}") void delete(@ApiParam("ID Solicitud de plaza observacion") @PathVariable Long id) {
		solicitudPlazaObservacionService.delete(id);
	}

}
