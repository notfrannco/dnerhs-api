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
import py.gov.mspbs.entity.Persona;
import py.gov.mspbs.service.PersonaService;

@RestController
@RequestMapping(value = "/personas", produces = MediaType.APPLICATION_JSON_VALUE)
public class PersonaController {

	@Autowired
	PersonaService personaService;

	@ApiOperation(value = "Listar personas", notes = "Lista de personas registradas o vacio si no hay registros")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Lista de personas"), })
	@GetMapping
	public List<Persona> findAll() {
		return personaService.findAll();
	}

	@ApiOperation(value = "Obtener persona por ID", notes = "Retorna una persona dado su ID")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Persona"),
			@ApiResponse(code = 404, message = "No se encontró persona") })
	@GetMapping("{id}")
	public Optional<Persona> findById(@ApiParam("ID Persona") @PathVariable("id") Long id) {
		return personaService.findById(id);
	}

	@ApiOperation(value = "Paginar personas", notes = "Retorna una lista paginada de personas")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Lista paginada de personas"), })
	@GetMapping("page")
	public Page<Persona> getPage(
			@ApiParam("Número de Página") @RequestParam(value = "page", defaultValue = "0", required = false) Integer page,
			@ApiParam("Tamaño de página") @RequestParam(value = "pageSize", defaultValue = "10", required = false) Integer pageSize) {
		return personaService.getPage(PageRequest.of(page, pageSize));
	}

	@ApiOperation(value = "Crear persona", notes = "Guarda los datos de una nueva persona")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Nueva Persona"), })
	@PostMapping(consumes =  MediaType.APPLICATION_JSON_VALUE)
	public Persona save(@ApiParam("Nueva Persona") @RequestBody @Valid Persona persona) {
		return personaService.save(persona);
	}

	@ApiOperation(value = "Actualizar persona", notes = "Actualiza los datos de una persona")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Persona Actualizada"), })
	@PutMapping(consumes =  MediaType.APPLICATION_JSON_VALUE)
	public Persona update(@ApiParam("Persona") @RequestBody @Valid Persona persona) {
		return personaService.update(persona);
	}

	@ApiOperation(value = "Eliminar persona", notes = "Elimina los datos de una persona")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Persona Eliminada"), })
	public @DeleteMapping("{id}") void delete(@ApiParam("ID Persona") @PathVariable Long id) {
		personaService.delete(id);
	}

}
