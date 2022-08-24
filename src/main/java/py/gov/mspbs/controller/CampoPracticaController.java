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
import py.gov.mspbs.entity.CampoPractica;
import py.gov.mspbs.service.CampoPracticaService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/campos-practicas", produces = MediaType.APPLICATION_JSON_VALUE)
public class CampoPracticaController {

    @Autowired
    CampoPracticaService campoPracticaService;

    @ApiOperation(value = "Listar campos de prácticas", notes = "Lista de campos de práctica, vacío si no hay registros")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Lista de campos de práctica"), })
    @GetMapping
    public List<CampoPractica> findAll() {
        return campoPracticaService.findAll();
    }

    @ApiOperation(value = "Obtener campo de práctica por ID", notes = "Retorna un campo de práctica dado su ID")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Campo de práctica"),
            @ApiResponse(code = 404, message = "No se encontró campp de práctica ") })
    @GetMapping("{id}")
    public Optional<CampoPractica> findById(@ApiParam("ID Campo de práctica") @PathVariable("id") Long id) {
        return campoPracticaService.findById(id);
    }

    @ApiOperation(value = "Paginar campos de prácticas", notes = "Retorna una lista paginada de campos de práctica")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Lista paginada de campos de práctica"), })
    @GetMapping("page")
    public Page<CampoPractica> getPage(
            @ApiParam("Número de Página") @RequestParam(value = "page", defaultValue = "0", required = false) Integer page,
            @ApiParam("Tamaño de página") @RequestParam(value = "pageSize", defaultValue = "10", required = false) Integer pageSize) {
        return campoPracticaService.getPage(PageRequest.of(page, pageSize));
    }

    @ApiOperation(value = "Crear campo de práctica", notes = "Guarda los datos de un nuevo campo de práctica")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Nuevo CAmpo de práctica"), })
    @PostMapping(consumes =  MediaType.APPLICATION_JSON_VALUE)
    public CampoPractica save(@ApiParam("Nuevo campo de práctica") @RequestBody @Valid CampoPractica campoPractica) {
        return campoPracticaService.save(campoPractica);
    }

    @ApiOperation(value = "Actualizar campo de práctica", notes = "Actualiza los datos de un campo de práctica")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Campo de práctica actualizado"), })
    @PutMapping(consumes =  MediaType.APPLICATION_JSON_VALUE)
    public CampoPractica update(@ApiParam("Campo de práctica") @RequestBody @Valid CampoPractica campoPractica) {
        return campoPracticaService.update(campoPractica);
    }

    @ApiOperation(value = "Eliminar campo de práctica", notes = "Elimina los datos de un campo de práctica")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Campo de práctica eliminado"), })
    public @DeleteMapping("{id}") void delete(@ApiParam("ID Campo de práctica") @PathVariable Long id) {
        campoPracticaService.delete(id);
    }
}
