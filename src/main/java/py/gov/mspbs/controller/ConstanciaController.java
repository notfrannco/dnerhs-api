package py.gov.mspbs.controller;

import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import py.gov.mspbs.entity.Constancia;
import py.gov.mspbs.entity.ConstanciaDetalle;
import py.gov.mspbs.service.ConstanciaService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/constancias", produces = MediaType.APPLICATION_JSON_VALUE)
public class ConstanciaController {

    @Autowired
    ConstanciaService constanciaService;



    @GetMapping("/listado-practicas")
    public List<ConstanciaDetalle> findAllPracticas(
    	    @ApiParam("Número de Cédula") @RequestParam @Valid Integer cedula,
            @ApiParam("ID Carrera/Programa") @RequestParam @Valid Long carreraId,
            @ApiParam("ID Institución Formadora") @RequestParam @Valid Long formadoraId
    ){
        return constanciaService.findAllPracticas(carreraId, cedula, formadoraId);
    }

    @GetMapping("/{id}")
    public Optional<Constancia> findById(
            @ApiParam("ID Constancia") @PathVariable("id") Long id) {

        Optional<Constancia> constancia = constanciaService.findById(id);

        if (constancia.isPresent()){
            constancia.get().setFechaUltimaDescarga(new Date());
            constanciaService.update(constancia.get());
        }

        return constancia;
    }

    @GetMapping("/info/{id}")
    public Optional<Constancia> findInfoById(
            @ApiParam("ID Constancia") @PathVariable("id") Long id) {
        return constanciaService.findById(id);
    }



    @GetMapping("/estudiante")
    public List<Constancia> findAllByCedulaIdentidad(
            @ApiParam("Número de Cédula") @RequestParam @Valid Integer cedula) {
        return constanciaService.findAllByCedulaIdentidad(cedula);
    }


    @PostMapping(consumes =  MediaType.APPLICATION_JSON_VALUE)
    public Constancia saveConstancia(
            HttpServletRequest request,
            @ApiParam("Nueva Constancia") @RequestBody @Valid Constancia constancia) {

        constanciaService.save(constancia);
        String enlace = request.getRequestURL() + "/info/" + constancia.getId().toString();
        constancia.setCodigoEnlace(enlace);
        constanciaService.update(constancia);

        return constancia;
    }

    @PutMapping(consumes =  MediaType.APPLICATION_JSON_VALUE)
    public Constancia updateConstancia(
            @ApiParam("Constancia") @RequestBody @Valid Constancia constancia) {
        return constanciaService.update(constancia);
    }

    @DeleteMapping("{id}")
    public void deleteConstancia(@ApiParam("ID Constancia") @PathVariable Long id) {
        constanciaService.delete(id);
    }




}
