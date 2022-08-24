package py.gov.mspbs.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import py.gov.mspbs.entity.Decano;
import py.gov.mspbs.entity.Docente;
import py.gov.mspbs.service.DecanoService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/decanos", produces = MediaType.APPLICATION_JSON_VALUE)
public class DecanoController {

    @Autowired
    DecanoService decanoService;

    @ApiOperation(value = "Listar decanos", notes = "Lista de decanos registrados o vacio si no hay registros")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Lista de decanos"), })
    @GetMapping
    public List<Decano> findAll() {
        return decanoService.findAll();
    }

    @ApiOperation(value = "Obtener decano por ID", notes = "Retorna un decano dado su ID")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Decano"),
            @ApiResponse(code = 404, message = "No se encontró docente") })
    @GetMapping("{id}")
    public Optional<Decano> findById(@ApiParam("ID Decano") @PathVariable("id") Long id) {
        return decanoService.findById(id);
    }

    @ApiOperation(value = "Paginar decanos", notes = "Retorna una lista paginada de decanos")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Lista paginada de decanos"), })
    @GetMapping("page")
    public Page<Decano> getPage(
            @ApiParam("Número de Página") @RequestParam(value = "page", defaultValue = "0", required = false) Integer page,
            @ApiParam("Tamaño de página") @RequestParam(value = "pageSize", defaultValue = "10", required = false) Integer pageSize) {
        return decanoService.getPage(PageRequest.of(page, pageSize));
    }

    @ApiOperation(value = "Crear decano", notes = "Guarda los datos de un nuevo decano")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Nuevo decano"), })
    @PostMapping(consumes =  MediaType.APPLICATION_JSON_VALUE)
    public Decano save(@ApiParam("Nuevo Decano") @RequestBody @Valid Decano decano) {
        return decanoService.save(decano);
    }

    @ApiOperation(value = "Actualizar decano", notes = "Actualiza los datos de un decano")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Decano Actualizado"), })
    @PutMapping(consumes =  MediaType.APPLICATION_JSON_VALUE)
    public Decano update(@ApiParam("Decano") @RequestBody @Valid Decano decano) {
        return decanoService.update(decano);
    }

    @ApiOperation(value = "Eliminar decano", notes = "Elimina los datos de un decano")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Decano Eliminado"), })
    public @DeleteMapping("{id}") void delete(@ApiParam("ID Docente") @PathVariable Long id) {
        decanoService.delete(id);
    }


}
