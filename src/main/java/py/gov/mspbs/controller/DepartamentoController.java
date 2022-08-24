package py.gov.mspbs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import py.gov.mspbs.entity.Ciudad;
import py.gov.mspbs.entity.Departamento;
import py.gov.mspbs.service.CiudadService;
import py.gov.mspbs.service.DepartamentoService;

@RestController
@RequestMapping(value = "/departamentos", produces = MediaType.APPLICATION_JSON_VALUE)
public class DepartamentoController {

	@Autowired
	DepartamentoService departamentoService;

	@Autowired
	CiudadService ciudadService;

	@ApiOperation(value = "Listar departamentos", notes = "Lista de departamentos registrados o vacio si no hay registros")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Lista de departamentos"), })
	@GetMapping
	List<Departamento> findAll() {
		return departamentoService.findAll();
	}

	@ApiOperation(value = "Listar ciudades de un departamento", notes = "Lista de ciudades registradas de un departamento o vacio si no hay registros")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Lista de ciudades del departamento"), })
	@GetMapping("{id}/ciudades")
	List<Ciudad> findCiudadesByIdDepartamento(@ApiParam("ID Departamento") @PathVariable("id") Long id) {
		return ciudadService.findByIdDepartamento(id);
	}

}
