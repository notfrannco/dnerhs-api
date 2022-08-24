package py.gov.mspbs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import py.gov.mspbs.entity.Genero;
import py.gov.mspbs.service.GeneroService;

@RestController
@RequestMapping(value = "/generos", produces = MediaType.APPLICATION_JSON_VALUE)
public class GeneroController {

	@Autowired
	GeneroService generoService;

	@ApiOperation(value = "Listar géneros", notes = "Lista de géneros registrados o vacio si no hay registros")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Lista de generos"), })
	@GetMapping
	List<Genero> findAll() {
		return generoService.findAll();
	}

}
