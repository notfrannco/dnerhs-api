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
import py.gov.mspbs.entity.Semestre;
import py.gov.mspbs.service.SemestreService;

@RestController
@RequestMapping(value = "/semestres", produces = MediaType.APPLICATION_JSON_VALUE)
public class SemestreController {

	@Autowired
	SemestreService semestreService;

	@ApiOperation(value = "Listar semestres", notes = "Lista de semestres registrados o vacio si no hay registros")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Lista de semestres"), })
	@GetMapping
	public List<Semestre> findAll() {
		return semestreService.findAll();
	}

}
