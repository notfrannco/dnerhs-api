package py.gov.mspbs.controller;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import py.gov.mspbs.entity.NivelServicio;
import py.gov.mspbs.service.NivelServicioService;

import java.util.List;

@RestController
@RequestMapping(value = "niveles-servicios")
public class NivelServicioController {

    @Autowired
    NivelServicioService nivelServicioService;

    @GetMapping
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Lista de Niveles de Servicios"), })
    List<NivelServicio> findAll() {
        return nivelServicioService.findAll();
    }
}
