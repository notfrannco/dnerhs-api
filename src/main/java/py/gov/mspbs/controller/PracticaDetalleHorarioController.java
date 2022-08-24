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
import py.gov.mspbs.entity.PracticaDetalleHorario;
import py.gov.mspbs.service.PracticaDetalleHorarioService;

@RestController
@RequestMapping(value = "/practicas-detalles-horarios", produces = MediaType.APPLICATION_JSON_VALUE)
public class PracticaDetalleHorarioController {

	@Autowired
	PracticaDetalleHorarioService practicaDetalleHorarioService;

	@ApiOperation(value = "Listar campos de practica detalle horario", notes = "Lista de campos de practica detalle horario, vacío si no hay registros")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Lista de campos de practica detalle horario"), })
	@GetMapping
	public List<PracticaDetalleHorario> findAll() {
		return practicaDetalleHorarioService.findAll();
	}

	@ApiOperation(value = "Obtener practica detalle horario por ID", notes = "Retorna una practica detalle horario dada su ID")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Practica detalle horario"),
			@ApiResponse(code = 404, message = "No se encontró practica detalle horario") })
	@GetMapping("{id}")
	public Optional<PracticaDetalleHorario> findById(@ApiParam("ID Practica detalle horario") @PathVariable("id") Long id) {
		return practicaDetalleHorarioService.findById(id);
	}

	@ApiOperation(value = "Obtener practica detalle horario por Practica detalle ID", notes = "Retorna una lista de practicas detalles horarios dada el ID de practica detalle")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Practica detalle horario por Practica detalle ID"),
			@ApiResponse(code = 404, message = "No se encontró practicas detalles horarios para esa Practica detalle ID") })
	@GetMapping("{id}/horarios")
	public List<PracticaDetalleHorario> findByIdPracticaDetalle(@ApiParam("ID Practica Detalle") @PathVariable("id") Long id) {
		return practicaDetalleHorarioService.findByPracticaDetalleId(id);
	}

	@ApiOperation(value = "Crear practica detalle horario", notes = "Guarda los datos de una nueva practica detalle horario")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Nueva Practica detalle horario"), })
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public PracticaDetalleHorario save(@ApiParam("Nueva Practica detalle horario") @RequestBody @Valid PracticaDetalleHorario practicaDetalleHorario) {
		return practicaDetalleHorarioService.save(practicaDetalleHorario);
	}

	@ApiOperation(value = "Actualizar practica detalle horario", notes = "Actualiza los datos de una practica detalle horario")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Practica detalle horario Actualizado"), })
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public PracticaDetalleHorario update(@ApiParam("Practica detalle horario") @RequestBody @Valid PracticaDetalleHorario practicaDetalleHorario) {
		return practicaDetalleHorarioService.update(practicaDetalleHorario);
	}

	@ApiOperation(value = "Eliminar practica detalle horario", notes = "Elimina los datos de una practica detalle horario")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Practica detalle horario Eliminado"), })
	public @DeleteMapping("{id}") void delete(@ApiParam("ID Practica detalle horario") @PathVariable Long id) {
		practicaDetalleHorarioService.delete(id);
	}

}
