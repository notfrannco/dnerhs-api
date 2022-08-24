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
import py.gov.mspbs.entity.CarreraPrograma;
import py.gov.mspbs.service.CarreraProgramaService;

@RestController
@RequestMapping(value = "/carreras-programas", produces = MediaType.APPLICATION_JSON_VALUE)
public class CarreraProgramaController {

	@Autowired
    CarreraProgramaService carreraProgramaService;
	
	@ApiOperation(value = "Listar carreras programas", notes = "Lista de carreras programas registradas o vacio si no hay registros")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Lista de carreras programas"), })
	@GetMapping
	List<CarreraPrograma> findAll() {
		return carreraProgramaService.findAll();
	}

	@ApiOperation(value = "Obtener carrera por ID", notes = "Retorna una carrera dado su ID")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Carrera"),
			@ApiResponse(code = 404, message = "No se encontró carrera") })
	@GetMapping("{id}")
	public Optional<CarreraPrograma> findById(@ApiParam("ID Carrera") @PathVariable("id") Long id) {
		return carreraProgramaService.findById(id);
	}
	
	@ApiOperation(value = "Paginar carreras programas", notes = "Retorna una lista paginada de las carreras programas")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Lista paginada carreras programas"), })
	@GetMapping("/page")
	public Page<CarreraPrograma> getPageInstitucionFormadora(
			@ApiParam("Número de página") @RequestParam(value = "page", defaultValue = "0", required = false) Integer page,
			@ApiParam("Tamaño de página") @RequestParam(value = "pageSize", defaultValue = "10", required = false) Integer pageSize) {
		return carreraProgramaService.getPage(PageRequest.of(page, pageSize));
	}

	@ApiOperation(value = "Crear carrera", notes = "Guarda los datos de una nueva carrera")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Nueva Carrera"), })
	@PostMapping(consumes =  MediaType.APPLICATION_JSON_VALUE)
	public CarreraPrograma save(@ApiParam("Nueva Carrera") @RequestBody @Valid CarreraPrograma carrera) {
		return carreraProgramaService.save(carrera);
	}

	@ApiOperation(value = "Actualizar carrera", notes = "Actualiza los datos de una carrera")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Carrera Actualizada"), })
	@PutMapping(consumes =  MediaType.APPLICATION_JSON_VALUE)
	public CarreraPrograma update(@ApiParam("Carrera") @RequestBody @Valid CarreraPrograma carrera) {
		return carreraProgramaService.update(carrera);
	}

	@ApiOperation(value = "Eliminar carrera", notes = "Elimina los datos de un carrera")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Carrera Eliminada"), })
	public @DeleteMapping("{id}") void delete(@ApiParam("ID Carrera") @PathVariable Long id) {
		carreraProgramaService.delete(id);
	}

}
