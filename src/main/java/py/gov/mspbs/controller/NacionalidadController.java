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
import py.gov.mspbs.entity.Nacionalidad;
import py.gov.mspbs.service.NacionalidadService;

@RestController
@RequestMapping(value = "/nacionalidades", produces = MediaType.APPLICATION_JSON_VALUE)
public class NacionalidadController {

	@Autowired
	NacionalidadService nacionalidadService;

	@ApiOperation(value = "Listar nacionalidades", notes = "Lista de nacionalidades registradas o vacio si no hay registros")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Lista de nacionalidades"), })
	@GetMapping
	public List<Nacionalidad> findAll() {
		return nacionalidadService.findAll();
	}

	@ApiOperation(value = "Obtener nacionalidad por ID", notes = "Retorna una nacionalidad dado su ID")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Nacionalidad"),
			@ApiResponse(code = 404, message = "No se encontró nacionalidad") })
	@GetMapping("{id}")
	public Optional<Nacionalidad> findById(@ApiParam("ID Nacionalidad") @PathVariable("id") Long id) {
		return nacionalidadService.findById(id);
	}

	@ApiOperation(value = "Paginar nacionalidades", notes = "Retorna una lista paginada de nacionalidades")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Lista paginada de nacionalidades"), })
	@GetMapping("page")
	public Page<Nacionalidad> getPage(
			@ApiParam("Número de Página") @RequestParam(value = "page", defaultValue = "0", required = false) Integer page,
			@ApiParam("Tamaño de página") @RequestParam(value = "pageSize", defaultValue = "10", required = false) Integer pageSize) {
		return nacionalidadService.getPage(PageRequest.of(page, pageSize));
	}

	@ApiOperation(value = "Crear nacionalidad", notes = "Guarda los datos de una nueva nacionalidad")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Nueva Nacionalidad"), })
	@PostMapping(consumes =  MediaType.APPLICATION_JSON_VALUE)
	public Nacionalidad save(@ApiParam("Nueva Nacionalidad") @RequestBody @Valid Nacionalidad nacionalidad) {
		return nacionalidadService.save(nacionalidad);
	}

	@ApiOperation(value = "Actualizar nacionalidad", notes = "Actualiza los datos de una nacionalidad")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Nacionalidad Actualizada"), })
	@PutMapping(consumes =  MediaType.APPLICATION_JSON_VALUE)
	public Nacionalidad update(@ApiParam("Nacionalidad") @RequestBody @Valid Nacionalidad nacionalidad) {
		return nacionalidadService.update(nacionalidad);
	}

	@ApiOperation(value = "Eliminar nacionalidad", notes = "Elimina los datos de una nacionalidad")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Nacionalidad Eliminada"), })
	public @DeleteMapping("{id}") void delete(@ApiParam("ID Nacionalidad") @PathVariable Long id) {
		nacionalidadService.delete(id);
	}

}
