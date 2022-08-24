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
import py.gov.mspbs.entity.Materia;
import py.gov.mspbs.service.MateriaService;

@RestController
@RequestMapping(value = "/materias", produces = MediaType.APPLICATION_JSON_VALUE)
public class MateriaController {

	@Autowired
	MateriaService materiaService;

	@ApiOperation(value = "Listar materias", notes = "Lista de materias registradas o vacio si no hay registros")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Lista de materias"), })
	@GetMapping
	public List<Materia> findAll() {
		return materiaService.findAll();
	}

	@ApiOperation(value = "Obtener materia por ID", notes = "Retorna una materia dado su ID")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Materia"),
			@ApiResponse(code = 404, message = "No se encontró materia") })
	@GetMapping("{id}")
	public Optional<Materia> findById(@ApiParam("ID Materia") @PathVariable("id") Long id) {
		return materiaService.findById(id);
	}

	@ApiOperation(value = "Paginar materias", notes = "Retorna una lista paginada de materias")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Lista paginada de materias"), })
	@GetMapping("page")
	public Page<Materia> getPage(
			@ApiParam("Número de Página") @RequestParam(value = "page", defaultValue = "0", required = false) Integer page,
			@ApiParam("Tamaño de página") @RequestParam(value = "pageSize", defaultValue = "10", required = false) Integer pageSize) {
		return materiaService.getPage(PageRequest.of(page, pageSize));
	}

	@ApiOperation(value = "Crear materia", notes = "Guarda los datos de una nueva materia")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Nueva Materia"), })
	@PostMapping(consumes =  MediaType.APPLICATION_JSON_VALUE)
	public Materia save(@ApiParam("Nueva Materia") @RequestBody @Valid Materia materia) {
		return materiaService.save(materia);
	}

	@ApiOperation(value = "Actualizar materia", notes = "Actualiza los datos de una materia")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Materia Actualizada"), })
	@PutMapping(consumes =  MediaType.APPLICATION_JSON_VALUE)
	public Materia update(@ApiParam("Materia") @RequestBody @Valid Materia materia) {
		return materiaService.update(materia);
	}

	@ApiOperation(value = "Eliminar materia", notes = "Elimina los datos de una materia")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Materia Eliminada"), })
	public @DeleteMapping("{id}") void delete(@ApiParam("ID Materia") @PathVariable Long id) {
		materiaService.delete(id);
	}

}
