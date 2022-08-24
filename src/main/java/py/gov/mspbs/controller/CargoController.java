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
import py.gov.mspbs.entity.Cargo;
import py.gov.mspbs.service.CargoService;

@RestController
@RequestMapping(value = "/cargos", produces = MediaType.APPLICATION_JSON_VALUE)
public class CargoController {

	@Autowired
	CargoService cargoService;

	@ApiOperation(value = "Listar cargos", notes = "Lista de cargos registrados o vacio si no hay registros")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Lista de cargos"), })
	@GetMapping
	List<Cargo> findAll() {
		return cargoService.findAll();
	}

}
