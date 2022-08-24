package py.gov.mspbs.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
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
import py.gov.mspbs.entity.PracticaDetalle;
import py.gov.mspbs.service.PracticaDetalleService;

@RestController
@RequestMapping(value = "/practicas-detalles", produces = MediaType.APPLICATION_JSON_VALUE)
public class PracticaDetalleController {

	@Autowired
	PracticaDetalleService practicaDetalleService;

	@ApiOperation(value = "Crear practica detalle", notes = "Guarda los datos de una nueva practica detalle")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Nueva Practica detalle"), })
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public PracticaDetalle save(@ApiParam("Nueva Practica detalle") @RequestBody @Valid PracticaDetalle practicaDetalle) {
		return practicaDetalleService.save(practicaDetalle);
	}

	@ApiOperation(value = "Actualizar practica detalle", notes = "Actualiza los datos de una practica detalle")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Practica detalle Actualizado"), })
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public PracticaDetalle update(@ApiParam("Practica detalle") @RequestBody @Valid PracticaDetalle practicaDetalle) {
		return practicaDetalleService.update(practicaDetalle);
	}

	@ApiOperation(value = "Eliminar practica detalle", notes = "Elimina los datos de una practica detalle")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Practica detalle Eliminado"), })
	public @DeleteMapping("{id}") void delete(@ApiParam("ID Practica detalle") @PathVariable Long id) {
		practicaDetalleService.delete(id);
	}

}
