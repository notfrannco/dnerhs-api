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
import py.gov.mspbs.entity.Autoridad;
import py.gov.mspbs.service.AutoridadService;

@RestController
@RequestMapping(value = "/autoridades", produces = MediaType.APPLICATION_JSON_VALUE)
public class AutoridadController {

	@Autowired
	AutoridadService autoridadService;

	@ApiOperation(value = "Listar autoridades", notes = "Lista de autoridades registrados o vacio si no hay registros")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Lista de autoridades"), })
	@GetMapping
	public List<Autoridad> findAll() {
		return autoridadService.findAll();
	}

	@ApiOperation(value = "Obtener autoridad por ID", notes = "Retorna una autoridad dado su ID")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Autoridad"),
			@ApiResponse(code = 404, message = "No se encontró autoridad") })
	@GetMapping("{id}")
	public Optional<Autoridad> findById(@ApiParam("ID Autoridad") @PathVariable("id") Long id) {
		return autoridadService.findById(id);
	}

	@ApiOperation(value = "Paginar autoridades", notes = "Retorna una lista paginada de autoridaes")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Lista paginada de autoridades"), })
	@GetMapping("page")
	public Page<Autoridad> getPage(
			@ApiParam("Número de Página") @RequestParam(value = "page", defaultValue = "0", required = false) Integer page,
			@ApiParam("Tamaño de página") @RequestParam(value = "pageSize", defaultValue = "10", required = false) Integer pageSize) {
		return autoridadService.getPage(PageRequest.of(page, pageSize));
	}

	@ApiOperation(value = "Crear autoridad", notes = "Guarda los datos de una nueva autoridad")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Nueva Autoridad"), })
	@PostMapping(consumes =  MediaType.APPLICATION_JSON_VALUE)
	public Autoridad save(@ApiParam("Nueva Autoridad") @RequestBody @Valid Autoridad autoridad) {
		return autoridadService.save(autoridad);
	}

	@ApiOperation(value = "Actualizar autoridad", notes = "Actualiza los datos de una autoridad")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Autoridad Actualizado"), })
	@PutMapping(consumes =  MediaType.APPLICATION_JSON_VALUE)
	public Autoridad update(@ApiParam("Autoridad") @RequestBody @Valid Autoridad autoridad) {
		return autoridadService.update(autoridad);
	}

	@ApiOperation(value = "Eliminar autoridad", notes = "Elimina los datos de una autoridad")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Autoridad Eliminada"), })
	public @DeleteMapping("{id}") void delete(@ApiParam("ID Autoridad") @PathVariable Long id) {
		autoridadService.delete(id);
	}

}
