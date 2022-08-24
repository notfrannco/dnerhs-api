package py.gov.mspbs.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import py.gov.mspbs.entity.SolicitudPlaza;
import py.gov.mspbs.service.SolicitudPlazaService;

@RestController
@RequestMapping(value = "/solicitudes-plazas", produces = MediaType.APPLICATION_JSON_VALUE)
public class SolicitudPlazaController {

	@Autowired
	SolicitudPlazaService solicitudPlazaService;

	@ApiOperation(value = "Listar campos de solicitud de plazas", notes = "Lista de campos de solicitudes de plazas, vacío si no hay registros")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Lista de campos de solicitudes de plazas"), })
	@GetMapping
	public List<SolicitudPlaza> findAll() {
		return solicitudPlazaService.findAll();
	}

	@ApiOperation(value = "Obtener solicitud plaza por ID", notes = "Retorna una solicitud plaza dada su ID")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Solicitud Plaza"),
			@ApiResponse(code = 404, message = "No se encontró solicitud plaza") })
	@GetMapping("{id}")
	public Optional<SolicitudPlaza> findById(@ApiParam("ID Solicitud Plaza") @PathVariable("id") Long id) {
		return solicitudPlazaService.findById(id);
	}

	@ApiOperation(value = "Paginar solicitudes plazas", notes = "Retorna una lista paginada de solicitudes plazas")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Lista paginada de solicitudes plazas"), })
	@GetMapping("page")
	public Page<SolicitudPlaza> getPage(
		  @ApiParam("Id Datos Establecimiento") @RequestParam(value = "datosEstablecimientoId", defaultValue = "0", required = false) Long datosEstablecimientoId,
			@ApiParam("Id Convenio") @RequestParam(value = "convenioId", defaultValue = "0", required = false) Long convenioId,
			@ApiParam("Número de Página") @RequestParam(value = "page", defaultValue = "0", required = false) Integer page,
			@ApiParam("Tamaño de página") @RequestParam(value = "pageSize", defaultValue = "10", required = false) Integer pageSize) {
		return solicitudPlazaService.getPage(datosEstablecimientoId, convenioId,PageRequest.of(page, pageSize));
	}

	@ApiOperation(value = "Solicitudes plazas aprobadas por carrera", notes = "Retorna una lista de solicitudes plazas aprobadas por carrera")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Lista de solicitudes plazas aprobadas por carrera"), })
	@GetMapping("aprobadas")
	public Optional<SolicitudPlaza> getAprobadas() {
		return solicitudPlazaService.getAprobadas();
	}

	@ApiOperation(value = "Obtener solicitud plaza por Institucion Formadora ID y Carrera Id", notes = "Retorna una lista de solicitudes plazas dada el ID de institucion formadora y carrera")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Solicitudes de Plazas por Institucion Formadora ID y Carrera ID"),
			@ApiResponse(code = 404, message = "No se encontró solicitudes plazas para esa Institucion Formadora ID y Carrera ID") })
	@GetMapping("{idFormadora}/{idCarrera}/asignaciones")
	public List<SolicitudPlaza> findByIdInstitucionFormadoraAndIdCarrera(@ApiParam("ID Institucion Formadora") @PathVariable("idFormadora") Long idFormadora, @ApiParam("ID Institucion Formadora") @PathVariable("idCarrera") Long idCarrera) {
		return solicitudPlazaService.findByConvenio_InstitucionFormadoraIdAndCarreraprogramaId(idFormadora, idCarrera);
	}

	@ApiOperation(value = "Crear solicitud plaza", notes = "Guarda los datos de una nueva solicitud de plaza")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Nueva Solicitud de plaza"), })
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public SolicitudPlaza save(@ApiParam("Nueva Solicitud Plaza") @RequestBody @Valid SolicitudPlaza solicitudPlaza) {
		return solicitudPlazaService.save(solicitudPlaza);
	}

	@ApiOperation(value = "Actualizar solicitud de plaza", notes = "Actualiza los datos de una solicitud de plaza")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Solicitud de plaza Actualizado"), })
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public SolicitudPlaza update(@ApiParam("Solicitud de plaza") @RequestBody @Valid SolicitudPlaza solicitudPlaza) {
		return solicitudPlazaService.update(solicitudPlaza);
	}

	@ApiOperation(value = "Actualizar solicitud de plaza Aprobar/Rechazar", notes = "Actualiza los datos de una solicitud de plaza al aprobar o rechazar")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Solicitud de plaza Actualizado"), })
	@PutMapping("{id}/{operacion}")
	public SolicitudPlaza updateAprobarRechazar(
		@ApiParam("ID Solicitud Plaza") @PathVariable("id") Long id,
		@ApiParam("Operacion Aprobar/Rechazar") @PathVariable("operacion") String operacion ,
		@ApiParam("Observación") @RequestParam(value = "observacion", defaultValue = "", required = false) String observacion) {
		return solicitudPlazaService.updateAprobarRechazar(id, operacion, observacion);
	}

	@ApiOperation(value = "Eliminar solicitud de plaza", notes = "Elimina los datos de una solicitud de plaza")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Solicitud de plaza Eliminado"), })
	public @DeleteMapping("{id}") void delete(@ApiParam("ID Solicitud de plaza") @PathVariable Long id) {
		solicitudPlazaService.delete(id);
	}

}
