package py.gov.mspbs.controller;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import py.gov.mspbs.entity.NombreServicio;
import py.gov.mspbs.service.NombreServicioService;

import java.util.List;

@RestController
@RequestMapping(value = "servicios", produces = MediaType.APPLICATION_JSON_VALUE)
public class NombreServicioController {

    @Autowired
    NombreServicioService nombreServicioService;

    @GetMapping
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Lista de Nombres de Servicios"), })
    List<NombreServicio> findAll(){
        return nombreServicioService.findAll();
    }

}
