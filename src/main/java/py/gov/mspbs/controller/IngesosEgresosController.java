package py.gov.mspbs.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import py.gov.mspbs.entity.IngresosEgresos;
import py.gov.mspbs.service.IngresosEgresosService;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/ingresos-egresos", produces = MediaType.APPLICATION_JSON_VALUE)
public class IngesosEgresosController {

    @Autowired
    IngresosEgresosService ingresosEgresosService;

    @ApiOperation(value = "Crear ...", notes = "Guarda los datos de una nueva ...")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Nueva ..."), })
    @PostMapping(consumes =  MediaType.APPLICATION_JSON_VALUE)
    public IngresosEgresos save(@ApiParam("Nueva ...") @RequestBody @Valid IngresosEgresos ingresosEgresos) {
        return ingresosEgresosService.save(ingresosEgresos);
    }
}
