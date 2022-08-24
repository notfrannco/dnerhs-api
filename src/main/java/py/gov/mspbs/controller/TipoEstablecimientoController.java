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
import py.gov.mspbs.entity.TipoEstablecimiento;
import py.gov.mspbs.service.TipoEstablecimientoService;

@RestController
@RequestMapping(value = "/tipos-establecimientos", produces = MediaType.APPLICATION_JSON_VALUE)
public class TipoEstablecimientoController {

	@Autowired
	TipoEstablecimientoService tipoEstablecimeintoService;

	@ApiOperation(value = "Listar tipos de establecimientos", notes = "Lista de tipos de establecimientos registrados o vacio si no hay registros")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Lista de tipos de establecimientos"), })
	@GetMapping
	public List<TipoEstablecimiento> findAll() {
		return tipoEstablecimeintoService.findAll();
	}

}
