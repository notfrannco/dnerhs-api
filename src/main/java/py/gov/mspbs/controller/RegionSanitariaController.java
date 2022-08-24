package py.gov.mspbs.controller;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import py.gov.mspbs.entity.RegionSanitaria;
import py.gov.mspbs.service.RegionSanitariaService;

import javax.swing.plaf.synth.Region;
import java.util.List;

@RestController
@RequestMapping(value = "regiones", produces = MediaType.APPLICATION_JSON_VALUE)
public class RegionSanitariaController {

    @Autowired
    RegionSanitariaService regionSanitariaService;

    @GetMapping
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Lista de Regiones Sanitarias"), })
    List<RegionSanitaria> findAll(){
        return regionSanitariaService.findAll();
    }

}
