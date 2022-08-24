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
import py.gov.mspbs.entity.PracticaObservacion;
import py.gov.mspbs.service.PracticaObservacionService;

@RestController
@RequestMapping(value = "/practicas-observaciones", produces = MediaType.APPLICATION_JSON_VALUE)
public class PracticaObservacionController {

	@Autowired
	PracticaObservacionService practicaObservacionService;

	@ApiOperation(value = "Listar campos de practicas observaciones", notes = "Lista de campos de practicas observaciones, vacío si no hay registros")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Lista de campos de practicas observaciones"), })
	@GetMapping
	public List<PracticaObservacion> findAll() {
		return practicaObservacionService.findAll();
	}

	@ApiOperation(value = "Obtener practica observacion por ID", notes = "Retorna una practica observacion dada su ID")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Practica Observacion"),
			@ApiResponse(code = 404, message = "No se encontró practica observacion") })
	@GetMapping("{id}")
	public Optional<PracticaObservacion> findById(@ApiParam("ID Practica Observacion") @PathVariable("id") Long id) {
		return practicaObservacionService.findById(id);
	}

	@ApiOperation(value = "Obtener practica observacion por Practica ID", notes = "Retorna una lista de practicas observaciones dada el ID de solicitudes de plaza")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Practicas Observaciones por Practica ID"),
			@ApiResponse(code = 404, message = "No se encontró practicas observaciones para esa Practica ID") })
	@GetMapping("{id}/observaciones")
	public List<PracticaObservacion> findByIdPractica(@ApiParam("ID Practica") @PathVariable("id") Long id) {
		return practicaObservacionService.findByPracticaId(id);
	}

	@ApiOperation(value = "Crear practica observacion", notes = "Guarda los datos de una nueva practica observacion")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Nueva Practica observacion"), })
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public PracticaObservacion save(@ApiParam("Nueva Practica Observacion") @RequestBody @Valid PracticaObservacion practicaObservacion) {
		return practicaObservacionService.save(practicaObservacion);
	}

	@ApiOperation(value = "Actualizar practica observacion", notes = "Actualiza los datos de una practica observacion")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Practica observacion Actualizado"), })
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public PracticaObservacion update(@ApiParam("Practica observacion") @RequestBody @Valid PracticaObservacion practicaObservacion) {
		return practicaObservacionService.update(practicaObservacion);
	}

	@ApiOperation(value = "Eliminar practica observacion", notes = "Elimina los datos de una practica observacion")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Practica observacion Eliminado"), })
	public @DeleteMapping("{id}") void delete(@ApiParam("ID Practica observacion") @PathVariable Long id) {
		practicaObservacionService.delete(id);
	}

}
