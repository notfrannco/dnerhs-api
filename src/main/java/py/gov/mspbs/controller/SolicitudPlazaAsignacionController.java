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
import py.gov.mspbs.entity.SolicitudPlazaAsignacion;
import py.gov.mspbs.service.SolicitudPlazaAsignacionService;

@RestController
@RequestMapping(value = "/solicitudes-plazas-asignaciones", produces = MediaType.APPLICATION_JSON_VALUE)
public class SolicitudPlazaAsignacionController {

	@Autowired
	SolicitudPlazaAsignacionService solicitudPlazaAsignacionService;

	@ApiOperation(value = "Listar campos de solicitud de plazas asignaciones", notes = "Lista de campos de solicitudes de plazas asignaciones, vacío si no hay registros")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Lista de campos de solicitudes de plazas asignaciones"), })
	@GetMapping
	public List<SolicitudPlazaAsignacion> findAll() {
		return solicitudPlazaAsignacionService.findAll();
	}

	@ApiOperation(value = "Obtener solicitud plaza asignacion por ID", notes = "Retorna una solicitud plaza asignacion dada su ID")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Solicitud Plaza Asignacion"),
			@ApiResponse(code = 404, message = "No se encontró solicitud plaza asignacion") })
	@GetMapping("{id}")
	public Optional<SolicitudPlazaAsignacion> findById(@ApiParam("ID Solicitud Plaza Asignacion") @PathVariable("id") Long id) {
		return solicitudPlazaAsignacionService.findById(id);
	}

	@ApiOperation(value = "Obtener solicitud plaza asignacion por Solicitud de plaza ID", notes = "Retorna una lista de solicitudes plazas asignaciones dada el ID de solicitudes de plaza")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Solicitudes de Plazas Asignaciones por Solicitud de Plaza ID"),
			@ApiResponse(code = 404, message = "No se encontró solicitudes plazas asignaciones para esa Solicitud de Plaza ID") })
	@GetMapping("{id}/asignaciones")
	public List<SolicitudPlazaAsignacion> findByIdSolicitudPlaza(@ApiParam("ID Solicitud Plaza") @PathVariable("id") Long id) {
		return solicitudPlazaAsignacionService.findBySolicitudPlazaId(id);
	}

	@ApiOperation(value = "Obtener solicitud plaza asignacion por Institucion Formadora ID y Carrera Id", notes = "Retorna una lista de solicitudes plazas asignaciones dada el ID de institucion formadora y carrera")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Solicitudes de Plazas Asignaciones por Institucion Formadora ID y Carrera ID"),
			@ApiResponse(code = 404, message = "No se encontró solicitudes plazas asignaciones para esa Institucion Formadora ID y Carrera ID") })
	@GetMapping("{idFormadora}/{idCarrera}/asignaciones")
	public List<SolicitudPlazaAsignacion> findByIdInstitucionFormadoraAndIdCarrera(@ApiParam("ID Institucion Formadora") @PathVariable("idFormadora") Long idFormadora, @ApiParam("ID Institucion Formadora") @PathVariable("idCarrera") Long idCarrera) {
		return solicitudPlazaAsignacionService.findBySolicitudPlaza_Convenio_InstitucionFormadoraIdAndSolicitudPlaza_CarreraprogramaId(idFormadora, idCarrera);
	}

	@ApiOperation(value = "Crear solicitud plaza asignacion", notes = "Guarda los datos de una nueva solicitud de plaza asignacion")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Nueva Solicitud de plaza asignacion"), })
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public SolicitudPlazaAsignacion save(@ApiParam("Nueva Solicitud Plaza Asignacion") @RequestBody @Valid SolicitudPlazaAsignacion solicitudPlazaAsignacion) {
		return solicitudPlazaAsignacionService.save(solicitudPlazaAsignacion);
	}

	@ApiOperation(value = "Actualizar solicitud de plaza asignacion", notes = "Actualiza los datos de una solicitud de plaza asignacion")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Solicitud de plaza asignacion Actualizado"), })
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public SolicitudPlazaAsignacion update(@ApiParam("Solicitud de plaza asignacion") @RequestBody @Valid SolicitudPlazaAsignacion solicitudPlazaAsignacion) {
		return solicitudPlazaAsignacionService.update(solicitudPlazaAsignacion);
	}

	@ApiOperation(value = "Eliminar solicitud de plaza asignacion", notes = "Elimina los datos de una solicitud de plaza asignacion")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Solicitud de plaza asignacion Eliminado"), })
	public @DeleteMapping("{id}") void delete(@ApiParam("ID Solicitud de plaza asignacion") @PathVariable Long id) {
		solicitudPlazaAsignacionService.delete(id);
	}

}
