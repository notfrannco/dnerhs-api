package py.gov.mspbs.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import py.gov.mspbs.constants.EstadoPractica;
import py.gov.mspbs.entity.*;
import py.gov.mspbs.model.ConvenioData;
import py.gov.mspbs.service.ConvenioCarreraProgramaService;
import py.gov.mspbs.service.ConvenioDecanoService;
import py.gov.mspbs.service.ConvenioDocumentosRespaldoService;
import py.gov.mspbs.service.ConvenioEstudianteService;
import py.gov.mspbs.service.ConvenioIngresosEgresosService;
import py.gov.mspbs.service.ConvenioPracticaService;
import py.gov.mspbs.service.ConvenioRectorService;
import py.gov.mspbs.service.ConvenioService;
import py.gov.mspbs.service.ConvenioTutorService;
import py.gov.mspbs.service.EmailService;
import py.gov.mspbs.service.EstablecimientosCarrerasPlazasService;
import py.gov.mspbs.service.InstitucionFormadoraResponsableMaximaAutoridadService;
import py.gov.mspbs.service.InstitucionFormadoraService;
import py.gov.mspbs.service.PracticaDetalleService;
import py.gov.mspbs.service.PracticaObservacionService;
import py.gov.mspbs.service.ProfesionalesFormadosService;
import py.gov.mspbs.service.SolicitudService;

@RestController
@RequestMapping(value = "/convenios", produces = MediaType.APPLICATION_JSON_VALUE)
public class ConvenioController {

    private static final String CARRERAPROGRAMA_PATH = "carreras-programas";
    private static final String ESTUDIANTE_PATH = "estudiantes";
    private static final String INGRESOS_EGRESOS_PATH = "ingresos-egresos";
    private static final String TUTOR_PATH = "tutores";
    private static final String DECANO_PATH = "decanos";
    private static final String RECTOR_PATH = "rector";
    private static final String PRACTICA_PATH = "practicas";
    private static final String RESPALDO_PATH = "documentos-respaldo";
    private static final String SOLICITUD_PATH = "Solicitudes";
    private static final String FORMADOS_PATH = "profesionales-formados";

    private static final String CREADO = "Convenio en proceso de creación por el responsable";
    private static final String PENDIENTE_REVISION = "Convenio pendiente de revisión por DNERHS";
    private static final String RECHAZADA = "Convenio con correcciones solicitadas por DNERHS";
    private static final String PENDIENTE_FIRMA = "Convenio pendiente de firma";
    private static final String FIRMADO = "Convenio firmado";

    private static final String FORBIDDEN_MESSAGE = "No tiene permisos para efectuar la operación solicitada";

    @Autowired
    ConvenioService convenioService;

    @Autowired
    ConvenioCarreraProgramaService convenioCarreraProgramaService;

    @Autowired
    ConvenioEstudianteService convenioEstudianteService;

    @Autowired
    ConvenioIngresosEgresosService convenioIngresosEgresosService;

    @Autowired
    ConvenioTutorService convenioTutorService;

    @Autowired
    ConvenioPracticaService convenioPracticaService;

    @Autowired
    ConvenioRectorService convenioRectorService;

    @Autowired
    ConvenioDecanoService convenioDecanoService;

    @Autowired
    ConvenioDocumentosRespaldoService convenioDocumentosRespaldoService;

    @Autowired
    SolicitudService solicitudService;

    @Autowired
    InstitucionFormadoraResponsableMaximaAutoridadService institucionFormadoraResponsableMaximaAutoridadService;

    @Autowired
    private EmailService emailService;

    @Autowired
    InstitucionFormadoraService institucionFormadoraService;

    @Autowired
    ProfesionalesFormadosService profesionalesFormadosService;

    @Autowired
    PracticaDetalleService practicaDetalleService;

    @Autowired
    PracticaObservacionService practicaObservacionService;

    @Autowired
    EstablecimientosCarrerasPlazasService establecimientoCarreraPlazaService;

    // Convenio

    @Secured({ "ROLE_ADMIN", "ROLE_DNERHS" })
    @ApiOperation(value = "Listar convenios", notes = "Lista los convenios registradas o vacio si no hay registros")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Lista de convenios"), })
    @GetMapping
    public List<Convenio> findAll() {
        return convenioService.findAll();
    }

    @Secured({ "ROLE_ADMIN", "ROLE_DNERHS" })
    @ApiOperation(value = "Listar convenios por estado", notes = "Lista convenios por estado")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Lista de convenios con estado señalado"), })
    @GetMapping("/estado={estado}")
    public List<Convenio> findAll(@ApiParam("Estado") @PathVariable String estado) {
        return convenioService.findConveniosByEstado(estado);
    }

    @ApiOperation(value = "Listar convenios vigentes", notes = "Lista convenios vigentes")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Lista de convenios vigentes"), })
    @GetMapping("/vigentes")
    public List<ConvenioData> findConveniosVigentes() {
        List<Convenio> convenios = convenioService.findConveniosVigentes(FIRMADO);
        List<ConvenioData> listado = new ArrayList<>();
        if (!convenios.isEmpty()) {
            for (Convenio c : convenios) {
                ConvenioData convenioData = new ConvenioData();
                convenioData.setInstitucionFormadora(c.getInstitucionFormadora().getInstitucion());
                convenioData.setFechaInicioVigencia(c.getFechaInicioVigencia());
                convenioData.setFechaFinVigencia(c.getFechaFinVigencia());
                convenioData.setSede(c.getInstitucionFormadora().getSede());
                convenioData.setCategoria(c.getCategoria());
                String carreras = "";
                List<ConvenioCarreraPrograma> listaCarreras = convenioCarreraProgramaService
                        .findByConvenioId(c.getId());
                if (!listaCarreras.isEmpty()) {
                    for (ConvenioCarreraPrograma cc : listaCarreras) {
                        carreras += cc.getCarreraPrograma().getDescripcion() + ", ";
                    }
                    // borrar el último ", " del string
                    convenioData.setCarreras(carreras.substring(0, carreras.length() - 2));
                }
                listado.add(convenioData);
            }
        }
        return listado;
    }

    @ApiOperation(value = "Obtener datos de un convenio por ID", notes = "Retorna un convenio dado su ID")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Convenio"),
            @ApiResponse(code = 404, message = "No se encontró el Convenio") })
    @GetMapping("/{id}")
    public Optional<Convenio> findConvenioById(
            @ApiParam("ID Convenio") @PathVariable("id") Long id) {

        permissionControlByConvenioId(id);

        return convenioService.findById(id);
    }

    @ApiOperation(value = "Crear convenio", notes = "Guarda los datos de un nuevo convenio")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Nuevo convenio creado"), })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Convenio saveConvenio(
            @ApiParam("Nueva Convenio") @RequestBody @Valid Convenio convenio) {
        convenio.setEstado(CREADO);

        permissionControlByFormadoraId(convenio.getInstitucionFormadora().getId());

        return convenioService.save(convenio);
    }

    @ApiOperation(value = "Actualizar los datos de un Convenio", notes = "Actualiza los datos de un Convenio")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Convenio actualizado"), })
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Convenio updateConvenio(
            @ApiParam("Convenio") @RequestBody @Valid Convenio convenio) {

        permissionControlByConvenioId(convenio.getId());

        return convenioService.update(convenio);
    }

    @ApiOperation(value = "Eliminar Convenio", notes = "Elimina los datos de un Convenio")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Convenio eliminado"), })
    @DeleteMapping("{id}")
    public void deleteConvenio(@ApiParam("ID Convenio") @PathVariable Long id) {

        permissionControlByConvenioId(id);

        convenioService.delete(id);
    }

    // Carrera/Programa

    @ApiOperation(value = "Listado paginado de las carreras/programas asociadas al convenioId indicado", notes = "Retorna las carreras/programas asociados al convenioId en forma paginada")
    @ApiResponses(value = { @ApiResponse(code = 200, message = ""), })
    @GetMapping("{convenioId}/" + CARRERAPROGRAMA_PATH)
    public List<ConvenioCarreraPrograma> findCarrerasByConvenioId(
            @ApiParam("ID Convenio") @PathVariable("convenioId") Long convenioId) {
        return convenioCarreraProgramaService.findByConvenioId(convenioId);
    }

    @ApiOperation(value = "Listar las carreras/programas asociadas al convenioId indicado", notes = "Retorna las carreras/programas asociados al convenioId")
    @ApiResponses(value = { @ApiResponse(code = 200, message = ""), })
    @GetMapping("{convenioId}/" + CARRERAPROGRAMA_PATH + "/page")
    public Page<ConvenioCarreraPrograma> getPageConvenioCarreraProgramaByConvenioId(
            @ApiParam("ID Convenio") @PathVariable("convenioId") Long convenioId,
            @ApiParam("Número de Página") @RequestParam(value = "page", defaultValue = "0", required = false) Integer page,
            @ApiParam("Tamaño de página") @RequestParam(value = "pageSize", defaultValue = "10", required = false) Integer pageSize) {

        permissionControlByConvenioId(convenioId);

        return convenioCarreraProgramaService.getPageFindByConvenioId(convenioId, PageRequest.of(page, pageSize));
    }

    @ApiOperation(value = "Obtener datos de una relación convenio carrera/programa por ID", notes = "Retorna una relación convenio carrera/programa dado su ID")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Convenio Carrera/Programa"),
            @ApiResponse(code = 404, message = "No se encontró el Convenio Carrera/Programa") })
    @GetMapping(value = CARRERAPROGRAMA_PATH + "/{id}")
    public Optional<ConvenioCarreraPrograma> findConvenioCarreraProgramaById(
            @ApiParam("ID Convenio") @PathVariable("id") Long id) {
        return convenioCarreraProgramaService.findById(id);
    }

    @ApiOperation(value = "Guardar relación de Convenio con una Carrera/Programa", notes = "Guarda la realación de Convenio con una Carrera/Programa")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Nuevo Convenio Carrera/Programa creado"), })
    @PostMapping(value = CARRERAPROGRAMA_PATH, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ConvenioCarreraPrograma saveConvenioCarreraPrograma(
            @ApiParam("Nueva Convenio Carrera/Programa") @RequestBody @Valid ConvenioCarreraPrograma convenioCarreraPrograma) {
        return convenioCarreraProgramaService.save(convenioCarreraPrograma);
    }

    @ApiOperation(value = "Actualizar relación de Convenio Carrera/Programa", notes = "Actualizar la realación de Convenio Carrera/Programa")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Convenio Carrera/Programa actualizado"), })
    @PutMapping(value = CARRERAPROGRAMA_PATH, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ConvenioCarreraPrograma updateConvenioCarreraPrograma(
            @ApiParam("Nueva Convenio Carrera/Programa") @RequestBody @Valid ConvenioCarreraPrograma convenioCarreraPrograma) {
        return convenioCarreraProgramaService.update(convenioCarreraPrograma);
    }

    @ApiOperation(value = "Eliminar una relación convenio carrera/programa", notes = "Elimina una relación convenio carrera/programa")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Convenio Carrera/Programa Eliminado") })
    @DeleteMapping(value = CARRERAPROGRAMA_PATH + "/{id}")
    public void deleteConvenioCarreraPrograma(@ApiParam("ID Convenio") @PathVariable("id") Long id) {
        convenioCarreraProgramaService.delete(id);
    }

    // Estudiantes

    @Secured({ "ROLE_USER" })
    @ApiOperation(value = "Guardar Estudiante", notes = "Guarda un Estudiante")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Nuevo Estudiante creado"), })
    @PostMapping(value = ESTUDIANTE_PATH, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ConvenioEstudiante saveConvenioEstudiante(
            @ApiParam("Nuevo Estudiante") @RequestBody @Valid ConvenioEstudiante convenioEstudiante) {

        permissionControlByConvenioId(convenioEstudiante.getConvenio().getId());

        return convenioEstudianteService.save(convenioEstudiante);
    }

    @ApiOperation(value = "Obtener Estudiante por ID", notes = "Retorna Estudiante dado su ID")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Estudiante"),
            @ApiResponse(code = 404, message = "No se encontró el Estudiante") })
    @GetMapping(value = ESTUDIANTE_PATH + "/{id}")
    public Optional<ConvenioEstudiante> findConvenioEstudianteById(
            @ApiParam("ID Convenio Estudiante") @PathVariable("id") Long id) {

        Optional<ConvenioEstudiante> estudiante = convenioEstudianteService.findById(id);

        permissionControlByConvenioId(estudiante.get().getConvenio().getId());

        return estudiante;
    }

    @ApiOperation(value = "Listar los estudiantes asociadas al convenioId indicado", notes = "Retorna todas los estudiantes asociados al convenioId indicado")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Listado de estudiantes asociados al convenioId indicado"), })
    @GetMapping("/{convenioId}/" + ESTUDIANTE_PATH)
    public List<ConvenioEstudiante> findEstudiantesByconvenioId(
            @ApiParam("ID Convenio") @PathVariable("convenioId") Long convenioId) {

        permissionControlByConvenioId(convenioId);

        return convenioEstudianteService.findByConvenioId(convenioId);
    }

    @ApiOperation(value = "Paginar listado de estudiantes asociados al convenioId indicado", notes = "Retorna una lista paginada de estudiantes asociados al convenioId indicado")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Lista paginada de estudiantes asociados al convenioId indicado"), })
    @GetMapping("/{convenioId}/" + ESTUDIANTE_PATH + "/page")
    public Page<ConvenioEstudiante> getPageConvenioEstudianteByConvenioId(
            @ApiParam("ID Convenio") @PathVariable("convenioId") Long convenioId,
            @ApiParam("Número de Página") @RequestParam(value = "page", defaultValue = "0", required = false) Integer page,
            @ApiParam("Tamaño de página") @RequestParam(value = "pageSize", defaultValue = "10", required = false) Integer pageSize) {

        permissionControlByConvenioId(convenioId);

        return convenioEstudianteService.getPageFindByConvenioId(convenioId, PageRequest.of(page, pageSize));
    }

    @Secured({ "ROLE_USER" })
    @ApiOperation(value = "Actualizar Convenio", notes = "Actualiza los datos de un Estudiante")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Estudiante Actualizado"), })
    @PutMapping(value = ESTUDIANTE_PATH, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ConvenioEstudiante updateConvenioEstudiante(
            @ApiParam("Estudiante") @RequestBody @Valid ConvenioEstudiante convenioEstudiante) {

        permissionControlByConvenioId(convenioEstudiante.getConvenio().getId());

        return convenioEstudianteService.update(convenioEstudiante);
    }

    @Secured({ "ROLE_USER" })
    @ApiOperation(value = "Eliminar Estudiante", notes = "Elimina un Estudiante dado su ID")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Estudiante Eliminado"), })
    public @DeleteMapping(value = ESTUDIANTE_PATH + "/{id}") void deleteConvenioEstudiante(
            @ApiParam("ID Estudiante") @PathVariable Long id) {

        Optional<ConvenioEstudiante> estudiante = convenioEstudianteService.findById(id);

        permissionControlByConvenioId(estudiante.get().getConvenio().getId());

        convenioEstudianteService.delete(id);
    }

    // Ingresos Egresos

    @ApiOperation(value = "Guardar relación de Convenio con Ingresos Egresos por año", notes = "Guarda la realación de Convenio con Ingresos Egresos por año")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Nueva relación Convenio Ingresos Egresos por año creado"), })
    @PostMapping(value = INGRESOS_EGRESOS_PATH, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ConvenioIngresosEgresos saveConvenioIngresosEgresos(
            @ApiParam("Nuevo Convenio Ingresos Egresos por año") @RequestBody @Valid ConvenioIngresosEgresos convenioIngresosEgresos) {
        return convenioIngresosEgresosService.save(convenioIngresosEgresos);
    }

    @ApiOperation(value = "Actualizar relación de Convenio Ingresos Egresos por año", notes = "Actualiza la realación Convenio Ingresos Egresos por año")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Convenio Ingresos Egresos por año actualizado"), })
    @PutMapping(value = INGRESOS_EGRESOS_PATH, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ConvenioIngresosEgresos updateConvenioIngresosEgresos(
            @ApiParam("Convenio Ingresos Egresos por año") @RequestBody @Valid ConvenioIngresosEgresos convenioIngresosEgresos) {
        return convenioIngresosEgresosService.update(convenioIngresosEgresos);
    }

    @ApiOperation(value = "Eliminar una relación Convenio Ingresos Egresos por año", notes = "Elimina una relación Convenio Ingresos Egresos por año")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Convenio Ingresos Egresos por año Eliminado") })
    @DeleteMapping(value = INGRESOS_EGRESOS_PATH + "/{id}")
    public void deleteConvenioIngresosEgresos(
            @ApiParam("ID Convenio Ingresos Egresos por año") @PathVariable("id") Long id) {
        convenioIngresosEgresosService.delete(id);
    }

    @ApiOperation(value = "Listar Ingresos Egresos por año asociados al convenioId indicado", notes = "Retorna los Ingresos Egresos por año asociados al convenioId indicado")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna los Ingresos Egresos por año asociados al convenioId"), })
    @GetMapping("{convenioId}/" + INGRESOS_EGRESOS_PATH)
    public List<ConvenioIngresosEgresos> findConvenioIngresosEgresosByConvenioId(
            @ApiParam("ID Convenio") @PathVariable("convenioId") Long convenioId) {
        return convenioIngresosEgresosService.findByConvenioId(convenioId);
    }

    @ApiOperation(value = "Obtener datos de una relación Convenio Ingresos Egresos por año por ID", notes = "Retorna una relación Convenio Ingresos Egresos por año dado su ID")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Convenio Ingresos Egresos por año"),
            @ApiResponse(code = 404, message = "No se encontró el Convenio Ingresos Egresos por año") })
    @GetMapping(value = INGRESOS_EGRESOS_PATH + "/{id}")
    public Optional<ConvenioIngresosEgresos> findConvenioIngresosEgresosById(
            @ApiParam("ID Convenio Ingresos Egresos por año") @PathVariable("id") Long id) {
        return convenioIngresosEgresosService.findById(id);
    }

    // Tutor

    @Secured({ "ROLE_USER" })
    @ApiOperation(value = "Guardar Tutor", notes = "Guarda un Tutor")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Nueva Tutor"), })
    @PostMapping(value = TUTOR_PATH, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ConvenioTutor saveConvenioTutor(
            @ApiParam("Nuevo Tutor") @RequestBody @Valid ConvenioTutor convenioTutor) {

        permissionControlByConvenioId(convenioTutor.getConvenio().getId());

        return convenioTutorService.save(convenioTutor);
    }

    @Secured({ "ROLE_USER" })
    @ApiOperation(value = "Actualizar Tutor", notes = "Actualiza la información de un Tutor")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Tutor actualizado"), })
    @PutMapping(value = TUTOR_PATH, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ConvenioTutor updateConvenioTutor(
            @ApiParam("Tutor") @RequestBody @Valid ConvenioTutor convenioTutor) {

        permissionControlByConvenioId(convenioTutor.getConvenio().getId());

        return convenioTutorService.update(convenioTutor);
    }

    @Secured({ "ROLE_USER" })
    @ApiOperation(value = "Eliminar un Tutor", notes = "Elimina un Tutor dado su id")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Tutor Eliminado") })
    @DeleteMapping(value = TUTOR_PATH + "/{id}")
    public void deleteConvenioTutor(@ApiParam("ID Tutor") @PathVariable("id") Long id) {

        Optional<ConvenioTutor> tutor = convenioTutorService.findById(id);
        permissionControlByConvenioId(tutor.get().getConvenio().getId());

        convenioTutorService.delete(id);
    }

    @ApiOperation(value = "Listar tutores asociados al convenioId indicado", notes = "Retorna los tutores asociados al convenioId indicado")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna los tutores asociados al convenioId"), })
    @GetMapping("{convenioId}/" + TUTOR_PATH)
    public List<ConvenioTutor> findConvenioTutorByConvenioId(
            @ApiParam("ID Convenio") @PathVariable("convenioId") Long convenioId) {

        permissionControlByConvenioId(convenioId);

        return convenioTutorService.findByConvenioId(convenioId);
    }

    @ApiOperation(value = "Lista paginada de tutores asociados al convenioId indicado", notes = "Retorna una lista paginada de los tutores asociados al convenioId indicado")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna los tutores asociados al convenioId de forma paginada"), })
    @GetMapping("{convenioId}/" + TUTOR_PATH + "/page")
    public Page<ConvenioTutor> getPageConvenioTutorByConvenioId(
            @ApiParam("ID Convenio") @PathVariable("convenioId") Long convenioId,
            @ApiParam("Número de Página") @RequestParam(value = "page", defaultValue = "0", required = false) Integer page,
            @ApiParam("Tamaño de página") @RequestParam(value = "pageSize", defaultValue = "10", required = false) Integer pageSize) {

        permissionControlByConvenioId(convenioId);

        return convenioTutorService.getPageByConvenioId(convenioId, PageRequest.of(page, pageSize));
    }

    @ApiOperation(value = "Obtener datos de un Tutor por ID", notes = "Retorna un Tutor dado su ID")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Tutor"),
            @ApiResponse(code = 404, message = "No se encontró el Tutor") })
    @GetMapping(value = TUTOR_PATH + "/{id}")
    public Optional<ConvenioTutor> findConvenioTutorById(
            @ApiParam("ID Tutor") @PathVariable("id") Long id) {

        Optional<ConvenioTutor> tutor = convenioTutorService.findById(id);
        permissionControlByConvenioId(tutor.get().getConvenio().getId());

        return convenioTutorService.findById(id);
    }

    // Rector

    @ApiOperation(value = "Guardar datos del Rector", notes = "Guarda los datos del Rector")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Nuevo Rector"), })
    @PostMapping(value = RECTOR_PATH, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ConvenioRector saveConvenioRector(
            @ApiParam("Nuevo Convenio Rector") @RequestBody @Valid ConvenioRector convenioRector) {
        return convenioRectorService.save(convenioRector);
    }

    @ApiOperation(value = "Actualizar datos del Rector", notes = "Actualiza los datos del Rector")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Convenio Rector Actualizado"), })
    @PutMapping(value = RECTOR_PATH, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ConvenioRector updateConvenioRector(
            @ApiParam("Convenio Rector") @RequestBody @Valid ConvenioRector convenioRector) {
        return convenioRectorService.update(convenioRector);
    }

    @ApiOperation(value = "Eliminar datos del Rector", notes = "Elimina los datos del Rector")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Convenio Rector eliminado") })
    @DeleteMapping(value = RECTOR_PATH + "/{id}")
    public void deleteConvenioRector(@ApiParam("ID Convenio Rector") @PathVariable("id") Long id) {
        convenioRectorService.delete(id);
    }

    @ApiOperation(value = "Obtener datos del Rector dado un convenio id", notes = "Retorna datos del Rector dado un convenio id")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Convenio Rector"), })
    @GetMapping("{convenioId}/" + RECTOR_PATH)
    public ConvenioRector findConvenioRectorByConvenioId(
            @ApiParam("ID Convenio") @PathVariable("convenioId") Long convenioId) {
        return convenioRectorService.findbyConvenioId(convenioId);
    }

    // Decano

    @ApiOperation(value = "Guardar relación de Convenio con un Decano", notes = "Guarda la realación de Convenio con un Decano")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Nuevo Decano"), })
    @PostMapping(value = DECANO_PATH, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ConvenioDecano saveConvenioDecano(
            @ApiParam("Nuevo Convenio Decano") @RequestBody @Valid ConvenioDecano convenioDecano) {
        return convenioDecanoService.save(convenioDecano);
    }

    @ApiOperation(value = "Actualizar la relación de Convenio con un Decano", notes = "Actualiza la realación de Convenio con un Decano")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Convenio Decano Actualizado"), })
    @PutMapping(value = DECANO_PATH, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ConvenioDecano updateConvenioDecano(
            @ApiParam("Convenio Decano") @RequestBody @Valid ConvenioDecano convenioDecano) {
        return convenioDecanoService.update(convenioDecano);
    }

    @ApiOperation(value = "Eliminar dla relación de Convenio con un Decano", notes = "Elimina la relación de Convenio Decano")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Convenio Decano eliminado") })
    @DeleteMapping(value = DECANO_PATH + "/{id}")
    public void deleteConvenioDecano(@ApiParam("ID Convenio Decano") @PathVariable("id") Long id) {
        convenioDecanoService.delete(id);
    }

    @ApiOperation(value = "Listar los decanos asociados a un convenio id", notes = "Retorna el listado de Decano asociados a un convenio id")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Convenio Decano"), })
    @GetMapping("{convenioId}/" + DECANO_PATH)
    public List<ConvenioDecano> findConvenioDecanoByConvenioId(
            @ApiParam("ID Convenio") @PathVariable("convenioId") Long convenioId) {
        return convenioDecanoService.findByConvenioId(convenioId);
    }

    @ApiOperation(value = "Obtener datos de un Decano por su ID", notes = "Retorna un Decano dado su ID")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Convenio Decano"),
            @ApiResponse(code = 404, message = "No se encontró el Convenio Decano") })
    @GetMapping(value = DECANO_PATH + "/{id}")
    public Optional<ConvenioDecano> findConvenioDecanoById(
            @ApiParam("ID Convenio Decano") @PathVariable("id") Long id) {
        return convenioDecanoService.findById(id);
    }

    // Documentos de respaldo

    @ApiOperation(value = "Guardar identificadores de Documentos de respaldo", notes = "Guarda los identificadores de documentos de respaldo")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Identificadores de documentos de Respaldo guardados") })
    @PostMapping(value = RESPALDO_PATH, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ConvenioDocumentosRespaldo saveConvenioDocumentosRespaldo(
            @ApiParam("Identificadores de Documentos de Respaldo") @RequestBody @Valid ConvenioDocumentosRespaldo convenioDocumentosRespaldo) {
        return convenioDocumentosRespaldoService.save(convenioDocumentosRespaldo);
    }

    @ApiOperation(value = "Actualizar identificadores de Documentos de respaldo", notes = "Actualiza los identificadores de documentos de respaldo")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Identificadores de documentos de Respaldo actulizados") })
    @PutMapping(value = RESPALDO_PATH, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ConvenioDocumentosRespaldo updateConvenioDocumentosRespaldo(
            @ApiParam("Identificadores de Documentos de Respaldo") @RequestBody @Valid ConvenioDocumentosRespaldo convenioDocumentosRespaldo) {
        return convenioDocumentosRespaldoService.update(convenioDocumentosRespaldo);
    }

    @ApiOperation(value = "Eliminar identificadores de Documentos de respaldo", notes = "Elimina los identificadores de documentos de respaldo")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Identificadores de documentos de Respaldo eliminados") })
    @DeleteMapping(value = RESPALDO_PATH + "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteConvenioDocumentosRespaldo(
            @ApiParam("Id Documentos de Respaldo") @PathVariable("id") Long id) {
        convenioDocumentosRespaldoService.delete(id);
    }

    @ApiOperation(value = "Obtener identificadores de Documentos de Respaldo correspondientes a un Convenio Id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna identificadores de Docuemntos de Respaldo correspondientes a un Convenio Id") })
    @GetMapping(value = "{convenioId}/" + RESPALDO_PATH)
    public ConvenioDocumentosRespaldo findConvenioDocumentosRespaldoByConvenioId(
            @ApiParam("Id Convenio") @PathVariable("convenioId") Long convenioId) {
        return convenioDocumentosRespaldoService.findByConvenioId(convenioId);
    }

    @ApiOperation(value = "Obtener identificadores de Documentos de Respaldo correspondientes a un Convenio Documentos de Respaldo Id")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna identificadores de Docuemntos de Respaldo") })
    @GetMapping(value = RESPALDO_PATH + "/{id}")
    public Optional<ConvenioDocumentosRespaldo> findConvenioDocumentosReslpaldoById(
            @ApiParam("Id Documentos de Resplado") @PathVariable("id") Long id) {
        return convenioDocumentosRespaldoService.findById(id);
    }

    // Prácticas

    @ApiOperation(value = "Obtiene una practica según ID indicado", notes = "Retorna la práctica asociada seǵun ID Indicado")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna la práctica asociada seǵun ID Indicado"), })
    @GetMapping(PRACTICA_PATH + "/{id}")
    public Optional<Practica> findPracticaById(
            @ApiParam("ID Practica") @PathVariable("id") Long id) {

        Optional<Practica> practica = convenioPracticaService.findById(id);
        permissionControlByConvenioId(practica.get().getConvenio().getId());

        return practica;
    }

    @ApiOperation(value = "Listar prácticas asociadas al convenio ID indicado", notes = "Retorna las prácticas asociadas al convenioId indicado")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna las prácticas asociados al convenioId"), })
    @GetMapping("{convenioId}/" + PRACTICA_PATH)
    public List<Practica> findPracticasByConvenioId(
            @ApiParam("ID Convenio") @PathVariable("convenioId") Long convenioId) {

        permissionControlByConvenioId(convenioId);

        return convenioPracticaService.findByConvenioId(convenioId);
    }

    @ApiOperation(value = "Paginar Prácticas asociadas a un Convenio ID", notes = "Retorna una lista paginada de Prácticas dado un convenio ID")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Lista paginada de prácticas"), })
    @GetMapping("{convenioId}/" + PRACTICA_PATH + "/page")
    public Page<Practica> getPracticasPage(
            @ApiParam("ID Convenio") @PathVariable("convenioId") Long convenioId,
            @ApiParam("Número de Página") @RequestParam(value = "page", defaultValue = "0", required = false) Integer page,
            @ApiParam("Tamaño de página") @RequestParam(value = "pageSize", defaultValue = "10", required = false) Integer pageSize) {

        permissionControlByConvenioId(convenioId);

        return convenioPracticaService.getPageFindByConvenioId(convenioId, PageRequest.of(page, pageSize));
    }

    @ApiOperation(value = "Paginar Prácticas aprobadas asociadas a un Convenio ID", notes = "Retorna una lista paginada de Prácticas aprobadas dado un convenio ID")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Lista paginada de prácticas aprobadas"), })
    @GetMapping("{convenioId}/" + PRACTICA_PATH + "/aprobadas/page")
    public Page<Practica> getPracticasAprobadasPage(
            @ApiParam("ID Convenio") @PathVariable("convenioId") Long convenioId,
            @ApiParam("Número de Página") @RequestParam(value = "page", defaultValue = "0", required = false) Integer page,
            @ApiParam("Tamaño de página") @RequestParam(value = "pageSize", defaultValue = "10", required = false) Integer pageSize) {

        permissionControlByConvenioId(convenioId);

        return convenioPracticaService.getPracticasAprobadasPageByConvenioId(convenioId,
                PageRequest.of(page, pageSize));
    }

    @Secured({ "ROLE_USER" })
    @ApiOperation(value = "Guardar Práctica", notes = "Guarda los datos de un nueva Práctica")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Nueva Práctica guardada"), })
    @PostMapping(value = PRACTICA_PATH, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Practica savePractica(@ApiParam("Nueva Práctica") @RequestBody @Valid Practica practica) {

        permissionControlByConvenioId(practica.getConvenio().getId());

        practica.setEstado(EstadoPractica.PRACTICA_CREADA);

        return convenioPracticaService.save(practica);
    }

    @Secured({ "ROLE_USER" })
    @ApiOperation(value = "Actualizar Práctica", notes = "Actualiza los datos de una Práctica")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Práctica Actualizado"), })
    @PutMapping(value = PRACTICA_PATH, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Practica updatePractica(@ApiParam("Práctica") @RequestBody @Valid Practica practica) {

        permissionControlByConvenioId(practica.getConvenio().getId());

        /*if (practica.getEstado().equals(EstadoPractica.PRACTICA_MODIFICACIONES_APROBADA)) {
            throw new ResponseStatusException(
                    HttpStatus.FORBIDDEN, FORBIDDEN_MESSAGE);
        }*/
        return convenioPracticaService.update(practica);
    }

    @Secured({ "ROLE_USER" })
    @ApiOperation(value = "Eliminar Práctica", notes = "Elimina todos los datos de una Práctica")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Práctica Eliminada"), })
    @DeleteMapping(value = PRACTICA_PATH + "/{id}")
    public void deletePractica(@ApiParam("ID Práctica") @PathVariable Long id) {

        Optional<Practica> practica = convenioPracticaService.findById(id);
        permissionControlByConvenioId(practica.get().getConvenio().getId());

        convenioPracticaService.delete(id);
    }

    // Revisión Prácticas
    @Secured({ "ROLE_DNERHS" })
    @ApiOperation(value = "Aprobar/Rechazar Práctica", notes = "Registra la aprobación o el rechazo de una práctica")
    @PostMapping(value = PRACTICA_PATH + "/{id}/aprobacion")
    void revisionPractica(
            @ApiParam("ID Práctica") @PathVariable Long id,
            @ApiParam("Estado") @RequestParam(value = "estado", required = true) String estado,
            @ApiParam("Observación") @RequestParam(value = "observacion", required = false) String observacion) {
        Optional<Practica> practica = convenioPracticaService.findById(id);

        if (practica.isPresent() && estado.equals(EstadoPractica.PRACTICA_APROBADA)
                || estado.equals(EstadoPractica.PRACTICA_RECHAZADA)
                || estado.equals(EstadoPractica.PRACTICA_MODIFICACIONES_APROBADA)) {
            practica.get().setEstado(estado);

            String texto = "";

            if (estado.equals(EstadoPractica.PRACTICA_APROBADA)
                    || estado.equals(EstadoPractica.PRACTICA_MODIFICACIONES_APROBADA)) {
                // practica.get().setObservacion("");
                texto = "Estado de Práctica: " + estado + ".";

                // Cambiar modificado a false
                List<PracticaDetalle> practicaDetalleList = practica.get().getPracticaDetalleList();
                Long idInstitucionFormadora = practica.get().getConvenio().getInstitucionFormadora().getId();
                Long idCarreraPrograma = practica.get().getConvenioCarrera().getCarreraPrograma().getId();
                int cantidad = 0;
                for (PracticaDetalle practicaDetalle : practicaDetalleList) {
                    practicaDetalle.setModificado(false);
                    System.out.println("Practica detalle: -> Institución Formadora id: " + idInstitucionFormadora);
                    System.out.println("Practica detalle: -> Institución Establecimiento id: "
                            + practicaDetalle.getEstablecimiento().getId());
                    System.out.println("Practica detalle: -> Carrera Programa id: " + idCarreraPrograma);
                    cantidad++;
                }
                System.out.println("Practica detalle: -> Cantidad: " + cantidad);
                InstitucionFormadora institucionFormadora = institucionFormadoraService.findById(idInstitucionFormadora)
                        .get();
                int asignadas = institucionFormadora.getAsignadas();
                int ocupadas = institucionFormadora.getOcupadas() + cantidad;
                int disponibles = asignadas - ocupadas;
                institucionFormadora.setOcupadas(ocupadas);
                institucionFormadora.setDisponibles(disponibles);
                institucionFormadoraService.save(institucionFormadora);

            } else if (estado.equals(EstadoPractica.PRACTICA_RECHAZADA)) {
                // practica.get().setObservacion(observacion);
                texto = "Estado de Práctica: " + estado + ". Pedido de correcciones: " + observacion;
                PracticaObservacion practicaObservacion = new PracticaObservacion();
                practicaObservacion.setFechaObservacion(new Date());
                practicaObservacion.setObservacion(observacion);
                practicaObservacion.setPractica(practica.get());
                practicaObservacionService.save(practicaObservacion);
            }

            practica.get().setFechaRevision(new Date());
            UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
                    .getPrincipal();
            String username = userDetails.getUsername();
            practica.get().setUsuarioRevisor(username);

            convenioPracticaService.save(practica.get());

            // InstitucionFormadoraResponsableMaximaAutoridad responsable =
            // institucionFormadoraResponsableMaximaAutoridadService.
            // findbyFormadoraId(convenio.get().getInstitucionFormadora().getId());
            //
            // emailService.sendSimpleMessage(responsable.getResponsable().getEmail() + ","
            // + responsable.getMaximaAutoridad().getEmail(),// "Revisión de carga de datos
            // y documentación Sistema DNERHS", texto);

        }

    }

    // Solicitar Revisión Práctica
    @ApiOperation(value = "Solicitar Revisión Práctica", notes = "Registra la solicitud de revisión de una práctica")
    @PostMapping(value = PRACTICA_PATH + "/{id}/solicitar-revision")
    void solicitarRevisionPractica(
            @ApiParam("ID Práctica") @PathVariable Long id,
            @ApiParam("Estado") @RequestParam(value = "estado", required = true) String estado) {
        Optional<Practica> practica = convenioPracticaService.findById(id);
        permissionControlByConvenioId(practica.get().getConvenio().getId());

        if (practica.isPresent() && estado.equals(EstadoPractica.PRACTICA_PENDIENTE_APROBACION)
                || estado.equals(EstadoPractica.PRACTICA_PENDIENTE_MODIFICACIONES)) {
            practica.get().setEstado(estado);
            convenioPracticaService.save(practica.get());
        }

    }

    // Finalizar Cronograma Prácticas
    //@Secured({ "ROLE_DNERHS" })
    @ApiOperation(value = "Finalizar Cronograma Práctica", notes = "Registra la finalizacion de un cronograma de práctica")
    @PostMapping(value = PRACTICA_PATH + "/{id}/finalizar-cronograma")
    void finalizarCronogramaPractica(
            @ApiParam("ID Práctica") @PathVariable Long id,
            @ApiParam("Observación") @RequestParam(value = "observacion", required = false) String observacion) {
        Optional<Practica> practica = convenioPracticaService.findById(id);

        if (practica.isPresent()
                && practica.get().getEstado().equals(EstadoPractica.PRACTICA_APROBADA)
                || practica.get().getEstado().equals(EstadoPractica.PRACTICA_MODIFICACIONES_APROBADA)) {

            practica.get().setEstado(EstadoPractica.PRACTICA_CRONOGRAMA_FINALIZADA);

            List<PracticaDetalle> practicaDetalleList = practica.get().getPracticaDetalleList();
            Long idInstitucionFormadora = practica.get().getConvenio().getInstitucionFormadora().getId();
            Long idCarreraPrograma = practica.get().getConvenioCarrera().getCarreraPrograma().getId();
            int cantidad = 0;
            for (PracticaDetalle practicaDetalle : practicaDetalleList) {
                practicaDetalle.setModificado(false);
                System.out.println("Practica detalle: -> Institución Formadora id: " + idInstitucionFormadora);
                System.out.println("Practica detalle: -> Institución Establecimiento id: "
                        + practicaDetalle.getEstablecimiento().getId());
                System.out.println("Practica detalle: -> Carrera Programa id: " + idCarreraPrograma);
                cantidad++;

                EstablecimientosCarrerasPlazas establecimientosCarrerasPlazas = establecimientoCarreraPlazaService.findByNombreServicioIdAndCarreraprogramaId(practicaDetalle.getEstablecimiento().getId(), idCarreraPrograma).get();
                establecimientosCarrerasPlazas.setDisponible(establecimientosCarrerasPlazas.getDisponible() + 1);
                establecimientosCarrerasPlazas.setOcupadas(establecimientosCarrerasPlazas.getOcupadas() - 1);
                establecimientoCarreraPlazaService.update(establecimientosCarrerasPlazas);

            }
            System.out.println("Practica detalle: -> Cantidad: " + cantidad);
            InstitucionFormadora institucionFormadora = institucionFormadoraService.findById(idInstitucionFormadora)
                    .get();
            int asignadas = institucionFormadora.getAsignadas() - cantidad;
            int ocupadas = institucionFormadora.getOcupadas() - cantidad;
            int disponibles = asignadas - ocupadas;
            institucionFormadora.setAsignadas(asignadas);
            institucionFormadora.setOcupadas(ocupadas);
            institucionFormadora.setDisponibles(disponibles);
            institucionFormadoraService.save(institucionFormadora);

            PracticaObservacion practicaObservacion = new PracticaObservacion();
            practicaObservacion.setFechaObservacion(new Date());
            practicaObservacion.setObservacion(observacion);
            practicaObservacion.setPractica(practica.get());
            practicaObservacionService.save(practicaObservacion);

            convenioPracticaService.save(practica.get());
        }

    }

    // Profesionales Formados

    @ApiOperation(value = "Listado paginado de profesionales formados según al convenioId indicado", notes = "Retorna una lista paginada de profesionales formados asociados al convenioId indicado")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Lista paginada de profesionales formados asociados al convenioId indicado"), })
    @GetMapping("/{convenioId}/" + FORMADOS_PATH + "/page")
    public Page<ProfesionalesFormados> getProfesionalesFormadosByConvenioId(
            @ApiParam("ID Convenio") @PathVariable("convenioId") Long convenioId,
            @ApiParam("Número de Página") @RequestParam(value = "page", defaultValue = "0", required = false) Integer page,
            @ApiParam("Tamaño de página") @RequestParam(value = "pageSize", defaultValue = "10", required = false) Integer pageSize) {

        permissionControlByConvenioId(convenioId);

        return profesionalesFormadosService.getPageFindByConvenioId(convenioId, PageRequest.of(page, pageSize));
    }

    @GetMapping("{convenioId}/" + FORMADOS_PATH)
    public Optional<ProfesionalesFormados> findProfesionalesFormadosByConvenioId(
            @ApiParam("ID Convenio") @PathVariable("convenioId") Long convenioId) {

        permissionControlByConvenioId(convenioId);

        return profesionalesFormadosService.findByConvenioId(convenioId);
    }

    @GetMapping(FORMADOS_PATH + "/{id}")
    public Optional<ProfesionalesFormados> findProfesionalesFormadosById(
            @ApiParam("ID Profesionales Formados") @PathVariable("id") Long id) {

        Optional<ProfesionalesFormados> profesionalesFormados = profesionalesFormadosService.findById(id);

        if (profesionalesFormados.isPresent()) {
            permissionControlByConvenioId(profesionalesFormados.get().getConvenio().getId());
        }

        return profesionalesFormados;
    }

    @Secured("ROLE_USER")
    @PostMapping(value = FORMADOS_PATH, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ProfesionalesFormados saveProfesionalesFormados(
            @ApiParam("Nuevo Profesionales Formados") @RequestBody @Valid ProfesionalesFormados profesionalesFormados) {

        permissionControlByConvenioId(profesionalesFormados.getConvenio().getId());

        return profesionalesFormadosService.save(profesionalesFormados);
    }

    @Secured("ROLE_USER")
    @PutMapping(value = FORMADOS_PATH, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ProfesionalesFormados updateProfesionalesFormados(
            @ApiParam("Profesionales Formados") @RequestBody @Valid ProfesionalesFormados profesionalesFormados) {

        permissionControlByConvenioId(profesionalesFormados.getConvenio().getId());

        return profesionalesFormadosService.update(profesionalesFormados);
    }

    @Secured({ "ROLE_USER" })
    @DeleteMapping(value = FORMADOS_PATH + "/{id}")
    public void deleteProfesionalesFormados(
            @ApiParam("ID Profesionales Formados") @PathVariable Long id) {

        Optional<ProfesionalesFormados> profesionalesFormados = profesionalesFormadosService.findById(id);
        permissionControlByConvenioId(profesionalesFormados.get().getConvenio().getId());

        profesionalesFormadosService.delete(id);
    }

    // Solicitar Revisión
    @ApiOperation(value = "Solictar Revisión", notes = "Registra la solicitud de revisión")
    @PostMapping(value = "{id}/revision")
    void solicitarRevision(
            @ApiParam("ID Convenio") @PathVariable Long id) {
        Optional<Convenio> convenio = convenioService.findById(id);

        if (convenio.isPresent()) {
            convenio.get().setEstado(PENDIENTE_REVISION);
            convenioService.save(convenio.get());
        }
    }

    // Revisión
    @ApiOperation(value = "Aprobar/Rechazar Revisión", notes = "Registra la aprobación o el rechazo de una revisión")
    @PostMapping(value = "{id}/aprobacion")
    void revision(
            @ApiParam("ID Convenio") @PathVariable Long id,
            @ApiParam("Estado") @RequestParam(value = "estado", required = true) String estado,
            @ApiParam("Observación") @RequestParam(value = "observacion", required = false) String observacion,
            @ApiParam("Fecha de firma") @RequestParam(value = "fechaFirma", required = false) Date fechaFirma,
            @ApiParam("Fecha de inicio de vigencia") @RequestParam(value = "fechaInicioVigencia", required = false) Date fechaInicioVigencia,
            @ApiParam("Fecha de fin de vigencia") @RequestParam(value = "fechaFinVigencia", required = false) Date fechaFinVigencia) {
        Optional<Convenio> convenio = convenioService.findById(id);

        if (convenio.isPresent()) {
            convenio.get().setEstado(estado);

            String texto = "";
            if (estado.equals(PENDIENTE_FIRMA)) {
                convenio.get().setObservacion("");
                texto = "Estado de Convenio: " + estado + ".";

            } else if (estado.equals(RECHAZADA)) {
                convenio.get().setObservacion(observacion);
                texto = "Estado de Convenio: " + estado + ". Pedido de correcciones: " + observacion;

            } else if (estado.equals(FIRMADO)) {
                convenio.get().setFechaFirma(fechaFirma);
                convenio.get().setFechaInicioVigencia(fechaInicioVigencia);
                convenio.get().setFechaFinVigencia(fechaFinVigencia);
            }

            convenio.get().setFechaRevision(new Date());
            UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
                    .getPrincipal();
            String username = userDetails.getUsername();
            convenio.get().setUsuarioRevisor(username);

            convenioService.save(convenio.get());

            InstitucionFormadoraResponsableMaximaAutoridad responsable = institucionFormadoraResponsableMaximaAutoridadService
                    .findbyFormadoraId(convenio.get().getInstitucionFormadora().getId());

            emailService.sendSimpleMessage(responsable.getResponsable().getEmail() + ","
                    + responsable.getMaximaAutoridad().getEmail(),
                    "Revisión de carga de datos y documentación Sistema DNERHS", texto);

            System.out.print(texto);

        }

    }

    // Confirmación de realización de la práctica
    @Secured("ROLE_USER")
    @PostMapping(value = PRACTICA_PATH + "/confirmacion/{detallePracticaId}")
    void confirmarRealizacion(
            @ApiParam("ID Practica") @PathVariable("detallePracticaId") Long detallePracticaId,
            @ApiParam("Confirmación") @RequestParam(value = "confirmacion", required = true) Boolean confirmacion) {

        Optional<PracticaDetalle> practicaDetalle = practicaDetalleService.findById(detallePracticaId);

        Long practicaId = practicaDetalleService.getPracticaId(detallePracticaId);
        Optional<Practica> practica = convenioPracticaService.findById(practicaId);
        permissionControlByConvenioId(practica.get().getConvenio().getId());

        if (practicaDetalle != null) {
            practicaDetalle.get().setConfirmacion(confirmacion);
            practicaDetalle.get().setFechaConfirmacion(new Date());

            practicaDetalleService.update(practicaDetalle.get());
        }
    }

    // Solicitud
    @ApiOperation(value = "Guardar identificador de Solicitud", notes = "Guarda identificador de Solicitud")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Identificador de solicitud") })
    @PostMapping(value = SOLICITUD_PATH, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Solicitud saveSolicitud(
            @ApiParam("Identificadores de Solicitud") @RequestBody @Valid Solicitud solicitud) {
        return solicitudService.save(solicitud);
    }

    @ApiOperation(value = "Actualizar identificador de solicitud", notes = "Actualiza identificador de solicitud")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Identificador de identificador de solicitud actualizado") })
    @PutMapping(value = SOLICITUD_PATH, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Solicitud updateSolicitud(
            @ApiParam("Identificador de Solicitud") @RequestBody @Valid Solicitud solicitud) {
        return solicitudService.update(solicitud);
    }

    @ApiOperation(value = "Eliminar identificador de solicitud", notes = "Elimina identificador de solicitud")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Identificadores de solicitud eliminado") })
    @DeleteMapping(value = SOLICITUD_PATH + "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteSolicitud(
            @ApiParam("Id Solicitud") @PathVariable("id") Long id) {
        solicitudService.delete(id);
    }

    @ApiOperation(value = "Obtener el identificador de solicitud correspondiente a un Convenio Id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna identificador de solicitud correspondiente a un Convenio Id") })
    @GetMapping(value = "{convenioId}/" + SOLICITUD_PATH)
    public Solicitud findSolicitudByConvenioId(
            @ApiParam("Id Convenio") @PathVariable("convenioId") Long convenioId) {
        return solicitudService.findByConvenioId(convenioId);
    }

    @ApiOperation(value = "Obtener identificador de solicitud por si Id")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna identificador de solicitud") })
    @GetMapping(value = SOLICITUD_PATH + "/{id}")
    public Optional<Solicitud> findSolicitudById(
            @ApiParam("Id Solicitud") @PathVariable("id") Long id) {
        return solicitudService.findById(id);
    }

    private void permissionControlByConvenioId(Long convenioId) {
        if (!convenioService.hasPermission(convenioId)) {
            throw new ResponseStatusException(
                    HttpStatus.FORBIDDEN, FORBIDDEN_MESSAGE);
        }
    }

    private void permissionControlByFormadoraId(Long formadoraId) {
        if (!institucionFormadoraService.hasPermission(formadoraId)) {
            throw new ResponseStatusException(
                    HttpStatus.FORBIDDEN, FORBIDDEN_MESSAGE);
        }
    }

}