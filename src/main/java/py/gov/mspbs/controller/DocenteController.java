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
import py.gov.mspbs.entity.Docente;
import py.gov.mspbs.service.DocenteService;

@RestController
@RequestMapping(value = "/docentes", produces = MediaType.APPLICATION_JSON_VALUE)
public class DocenteController {

	@Autowired
	DocenteService docenteService;

	@ApiOperation(value = "Listar docentes", notes = "Lista de docentes registrados o vacio si no hay registros")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Lista de docentes"), })
	@GetMapping
	public List<Docente> findAll() {
		return docenteService.findAll();
	}

	@ApiOperation(value = "Obtener docente por ID", notes = "Retorna un docente dado su ID")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Docente"),
			@ApiResponse(code = 404, message = "No se encontró docente") })
	@GetMapping("{id}")
	public Optional<Docente> findById(@ApiParam("ID Docente") @PathVariable("id") Long id) {
		return docenteService.findById(id);
	}

	@ApiOperation(value = "Paginar docentes", notes = "Retorna una lista paginada de docentes")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Lista paginada de docentes"), })
	@GetMapping("page")
	public Page<Docente> getPage(
			@ApiParam("Número de Página") @RequestParam(value = "page", defaultValue = "0", required = false) Integer page,
			@ApiParam("Tamaño de página") @RequestParam(value = "pageSize", defaultValue = "10", required = false) Integer pageSize) {
		return docenteService.getPage(PageRequest.of(page, pageSize));
	}

	@ApiOperation(value = "Crear docente", notes = "Guarda los datos de un nuevo docente")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Nuevo Docente"), })
	@PostMapping(consumes =  MediaType.APPLICATION_JSON_VALUE)
	public Docente save(@ApiParam("Nuevo Docente") @RequestBody @Valid Docente docente) {
		return docenteService.save(docente);
	}

	@ApiOperation(value = "Actualizar docente", notes = "Actualiza los datos de un docente")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Docente Actualizado"), })
	@PutMapping(consumes =  MediaType.APPLICATION_JSON_VALUE)
	public Docente update(@ApiParam("Docente") @RequestBody @Valid Docente docente) {
		return docenteService.update(docente);
	}

	@ApiOperation(value = "Eliminar docente", notes = "Elimina los datos de un docente")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Docente Eliminado"), })
	public @DeleteMapping("{id}") void delete(@ApiParam("ID Docente") @PathVariable Long id) {
		docenteService.delete(id);
	}

}
