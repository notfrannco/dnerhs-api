package py.gov.mspbs.controller;

import java.util.ArrayList;
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
import org.springframework.security.crypto.password.PasswordEncoder;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.server.ResponseStatusException;
import py.gov.mspbs.entity.*;
import py.gov.mspbs.model.PracticaEstudianteDTO;
import py.gov.mspbs.service.*;

@RestController
@RequestMapping(value = "/instituciones", produces = MediaType.APPLICATION_JSON_VALUE)
public class InstitucionController {

	private static final String INSTITUCION_ESTABLECIMIENTO_PATH = "establecimientos";

	private static final String INSTITUCION_FORMADORA_PATH = "formadoras";

	private static final String RESPONSABLE_PATH = "responsables";

	private static final String CONVENIO_PATH = "convenios";

	private static final String PENDIENTE = "Solicitud pendiente de autorizaci??n por DNERHS";

	private static final String DATOS_PATH = "datos";

	private static final String ENCARGADO_PATH = "encargados";

	private static final String INFRAESTRUCTURA_PATH = "infraestructura";

	private static final String PROFESIONALES_PATH = "profesionales";

	private static final String SERVICIOS_PATH = "servicios";

	private static final String PLAZAS_PATH = "plazas";

	private static final String REGION_SANITARIA_PATH = "region_sanitaria";

	@Autowired
	InstitucionEstablecimientoService institucionEstablecimientoService;

	@Autowired
	InstitucionFormadoraService institucionFormadoraService;

	@Autowired
    InstitucionFormadoraResponsableMaximaAutoridadService institucionFormadoraResponsableService;

	@Autowired
	InstitucionService institucionService;

	@Autowired
	ResponsableService responsableService;

	@Autowired
	UsuarioService usuarioService;

	@Autowired
	ConvenioService convenioService;

	@Autowired
	ResponsableEstablecimientoService responsableEstablecimientoService;

	@Autowired
	DatosEstablecimientoService datosEstablecimientoService;

	@Autowired
	EncargadoService encargadoService;

	@Autowired
	InfraestructuraService infraestructuraService;

	@Autowired
	ProfesionalesSaludService profesionalesSaludService;

	@Autowired
	ServiciosService serviciosService;

	@Autowired
	PlazasService plazasService;

	@Autowired
	RoleService roleService;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Autowired
	private PracticaDetalleService practicaDetalleService;

	@Autowired
	private ConvenioPracticaService practicaService;


	//Formadoras

	@ApiOperation(value = "Listar instituciones formadoras", notes = "Lista las instituciones formadoras registrados o vacio si no hay registros")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Lista de instituciones formadoras"), })
	@GetMapping(INSTITUCION_FORMADORA_PATH)
	public List<InstitucionFormadora> findAllInstuticionFormadoras() {
		return institucionFormadoraService.findAll();
	}

	@ApiOperation(value = "Obtener institucion formadora por ID", notes = "Retorna una instituci??n formadora dado su ID")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Institucion Formadora"),
			@ApiResponse(code = 404, message = "No se encontr?? Institucion Formadora") })
	@GetMapping(INSTITUCION_FORMADORA_PATH + "/{id}")
	public Optional<InstitucionFormadora> findInstitucionFormadoraById(
			@ApiParam("ID Instituci??n Formadora") @PathVariable("id") Long id) {

		if (!institucionFormadoraService.hasPermission(id)){
			throw new ResponseStatusException(
					HttpStatus.FORBIDDEN, "No tiene permisos para ver la informaci??n solicitada");
		}

		return institucionFormadoraService.findById(id);
	}

	@ApiOperation(value = "Paginar instituciones formadoras", notes = "Retorna una lista paginada de instituciones formadoras")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Lista paginada de instituciones formadoras"), })
	@GetMapping(INSTITUCION_FORMADORA_PATH + "/page")
	public Page<InstitucionFormadora> getPageInstitucionFormadora(
			@ApiParam("N??mero de p??gina") @RequestParam(value = "page", defaultValue = "0", required = false) Integer page,
			@ApiParam("Tama??o de p??gina") @RequestParam(value = "pageSize", defaultValue = "10", required = false) Integer pageSize) {
		return institucionFormadoraService.getPage(PageRequest.of(page, pageSize));
	}

	@ApiOperation(value = "Crear instituci??n formadora", notes = "Guarda los datos de una nueva instituci??n formadora")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Nueva Instituci??n Formadora"), })
	@PostMapping(value = INSTITUCION_FORMADORA_PATH, consumes =  MediaType.APPLICATION_JSON_VALUE)
	public InstitucionFormadora saveInstitucionFormadora(
			@ApiParam("Nueva Instituci??n Formadora") @RequestBody @Valid InstitucionFormadora institucionFormadora) {
		return institucionFormadoraService.save(institucionFormadora);
	}

	@ApiOperation(value = "Actualizar instituci??n formadora", notes = "Actualiza los datos de una instituci??n formadora")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Instituci??n Formadoara actualizada"), })
	@PutMapping(value = INSTITUCION_FORMADORA_PATH, consumes =  MediaType.APPLICATION_JSON_VALUE)
	public InstitucionFormadora updateInstitucionFormadora(
			@ApiParam("Institucion Formadora") @RequestBody @Valid InstitucionFormadora institucionFormadora) {
		return institucionFormadoraService.update(institucionFormadora);
	}


	@ApiOperation(value = "Eliminar instituci??n formadora", notes = "Elimina los datos de una instituci??n formadora")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Instituci??n Formadora Eliminada"), })
	@DeleteMapping(INSTITUCION_FORMADORA_PATH + "/{id}")
	public void deleteInstitucionFormadora(@ApiParam("ID Instituci??n Formadora") @PathVariable Long id) {
		institucionFormadoraService.delete(id);
	}

	//Instituci??n Formadora Responsable

	@ApiOperation(value = "Listar relaciones entre Instituci??n y Responsables", notes = "Lista las relaciones entre Instituci??n y Responsables registradas o vacio si no hay registros")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Lista de relaciones entre Instituci??n y Responsables"), })
	@GetMapping(INSTITUCION_FORMADORA_PATH + "/" + RESPONSABLE_PATH)
	public List<InstitucionFormadoraResponsableMaximaAutoridad> findAllInstitucionFormadoraResponsables() {
		return institucionFormadoraResponsableService.findAll();
	}

	@ApiOperation(value = "Paginar listado de relaciones entre Instituci??n y Responsables", notes = "Retorna una lista paginada de relaciones entre Instituci??n y Responsables")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Lista paginada de relaciones entre Instituci??n y Responsables"), })
	@GetMapping(INSTITUCION_FORMADORA_PATH + "/" + RESPONSABLE_PATH + "/page")
	public Page<InstitucionFormadoraResponsableMaximaAutoridad> getPageInstitucionFormadoraResponsables(
			@ApiParam("N??mero de P??gina") @RequestParam(value = "page", defaultValue = "0", required = false) Integer page,
			@ApiParam("Tama??o de p??gina") @RequestParam(value = "pageSize", defaultValue = "10", required = false) Integer pageSize) {
		return institucionFormadoraResponsableService.getPage(PageRequest.of(page, pageSize));
	}

	@ApiOperation(value = "Listar relaciones entre Instituci??n y Responsables que tengan el estado se??alado", notes = "Lista las relaciones entre Instituci??n y Responsables que tengan el estado se??alado o vacio si no hay registros")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Lista de relaciones entre Instituci??n y Responsables con estado se??alado"), })
	@GetMapping(INSTITUCION_FORMADORA_PATH + "/" + RESPONSABLE_PATH + "/estado={estado}")
	public List<InstitucionFormadoraResponsableMaximaAutoridad> findAllInstitucionFormadoraResponsables(@ApiParam("Estado") @PathVariable String estado) {
		return institucionFormadoraResponsableService.findInstitucionFormadoraResponsableByEstado(estado);
	}

	@ApiOperation(value = "Paginar listado de relaciones entre Instituci??n y Responsables que tengan el estado se??alado", notes = "Retorna una lista paginada de relaciones entre Instituci??n y Responsables que tengan el estado se??alado")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Lista paginada de relaciones entre Instituci??n y Responsables"), })
	@GetMapping(INSTITUCION_FORMADORA_PATH + "/" + RESPONSABLE_PATH + "/estado={estado}/page")
	public Page<InstitucionFormadoraResponsableMaximaAutoridad> getPageInstitucionFormadoraResponsables(
			@ApiParam("Estado") @PathVariable String estado,
			@ApiParam("N??mero de P??gina") @RequestParam(value = "page", defaultValue = "0", required = false) Integer page,
			@ApiParam("Tama??o de p??gina") @RequestParam(value = "pageSize", defaultValue = "10", required = false) Integer pageSize) {
		return institucionFormadoraResponsableService.getPageInstitucionFormadoraResponsableByEstado(estado, PageRequest.of(page, pageSize));
	}

	@ApiOperation(value = "Obtener una relaci??n Instituci??n Formadora Responsable dado un ID", notes = "Retorna una relaci??n Instituci??n Formadora Responsable dado su ID")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Institucion Formadora"), @ApiResponse(code = 404, message = "No se encontr?? Institucion Formadora") })
	@GetMapping(INSTITUCION_FORMADORA_PATH + "/" + RESPONSABLE_PATH + "/{id}")
	public Optional<InstitucionFormadoraResponsableMaximaAutoridad> findInstitucionFormadoraResponsableById(
			@ApiParam("ID Instituci??n Formadora Responsable") @PathVariable("id") Long id) {
		return institucionFormadoraResponsableService.findById(id);
	}


	@ApiOperation(value = "Guarda una relaci??n Instituci??n Formadora Responsable", notes = "Guarda una relaci??n Instituci??n Formadora Responsable")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Nueva relaci??n Instituci??n Formadora Responsable"), })
	@PostMapping(value = INSTITUCION_FORMADORA_PATH + "/" + RESPONSABLE_PATH, consumes =  MediaType.APPLICATION_JSON_VALUE)
	public InstitucionFormadoraResponsableMaximaAutoridad saveInstitucionFormadoraResponsable(
			@ApiParam("Nueva Relaci??n Institucion Formadora Responsable") @RequestBody @Valid InstitucionFormadoraResponsableMaximaAutoridad institucionFormadoraResponsable) {
		institucionFormadoraResponsable.setEstado(PENDIENTE);
		return institucionFormadoraResponsableService.save(institucionFormadoraResponsable);
	}


	@ApiOperation(value = "Actualizar relaci??n Instituci??n Formadora Responsable", notes = "Actualiza la relaci??n Instituci??n Formadora Responsable")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Relaci??n Instituci??n Formadoara Responsable actualizada"), })
	@PutMapping(value = INSTITUCION_FORMADORA_PATH + "/" + RESPONSABLE_PATH, consumes =  MediaType.APPLICATION_JSON_VALUE)
	public InstitucionFormadoraResponsableMaximaAutoridad updateInstitucionFormadoraResponsable(
			@ApiParam("Institucion Formadora Responsable") @RequestBody @Valid InstitucionFormadoraResponsableMaximaAutoridad institucionFormadoraResponsable) {
		return institucionFormadoraResponsableService.update(institucionFormadoraResponsable);
	}

	@ApiOperation(value = "Eliminar relaci??n Instituci??n Formadora Responsable", notes = "Elimina los datos de una relaci??n Instituci??n Formadora Responsable")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Relaci??n Instituci??n Formadora Responsable Eliminada"), })
	@DeleteMapping(INSTITUCION_FORMADORA_PATH + "/" + RESPONSABLE_PATH + "/{id}")
	public void deleteInstitucionFormadoraResponsale(@ApiParam("ID Instituci??n Formadora Responsable") @PathVariable Long id) {
		institucionFormadoraResponsableService.delete(id);
	}


	//Instituciones

	@ApiOperation(value = "Listar instituciones", notes = "Lista las instituciones registradas o vacio si no hay registros")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Lista de instituciones"), })
	@GetMapping()
	public List<Institucion> findAllInstituciones() {
		return institucionService.findAll();
	}

	@ApiOperation(value = "Paginar listado de instituciones", notes = "Retorna una lista paginada de instituciones")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Lista paginada de instituciones"), })
	@GetMapping("/page")
	public Page<Institucion> getPageInstituciones(
			@ApiParam("N??mero de P??gina") @RequestParam(value = "page", defaultValue = "0", required = false) Integer page,
			@ApiParam("Tama??o de p??gina") @RequestParam(value = "pageSize", defaultValue = "10", required = false) Integer pageSize) {
		return institucionService.getPage(PageRequest.of(page, pageSize));
	}

	@ApiOperation(value = "Obtener institucion por ID", notes = "Retorna una instituci??n dado su ID")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Institucion"),
			@ApiResponse(code = 404, message = "No se encontr?? Institucion") })
	@GetMapping("/{id}")
	public Optional<Institucion> findInstitucionById(
			@ApiParam("ID Instituci??n") @PathVariable("id") Long id) {
		return institucionService.findById(id);
	}

	@ApiOperation(value = "Crear instituci??n", notes = "Guarda los datos de una nueva instituci??n")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Nueva Instituci??n"), })
	@PostMapping(consumes =  MediaType.APPLICATION_JSON_VALUE)
	public Institucion saveInstitucion(
			@ApiParam("Nueva Institucion") @RequestBody @Valid Institucion institucion) {
		return institucionService.save(institucion);
	}

	@ApiOperation(value = "Actualizar instituci??n", notes = "Actualiza los datos de una instituci??n")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Instituci??n actualizado"), })
	@PutMapping(consumes =  MediaType.APPLICATION_JSON_VALUE)
	public Institucion update(
			@ApiParam("Institucion") @RequestBody @Valid Institucion institucion) {
		return institucionService.update(institucion);
	}

	@ApiOperation(value = "Eliminar instituci??n", notes = "Elimina los datos de una instituci??n")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Instituci??n eliminado"), })
	@DeleteMapping("/{id}")
	public void deleteInstitucion(@ApiParam("ID Instituci??n") @PathVariable Long id) {
		institucionService.delete(id);
	}

	//Convenios

	@ApiOperation(value = "Listar convenios asociados a una Institucion Formadora",
			notes = "Retorna todos los convenios asociados a una Institucion Formadora")
	@ApiResponses(value = { @ApiResponse(code = 200, message = ""), })
	@GetMapping(INSTITUCION_FORMADORA_PATH + "/{institucionFormadoraId}/" + CONVENIO_PATH)
	public List<Convenio> findConvenioListByInstitucionFormadoraId(
			@ApiParam("ID Instituci??n Formadora") @PathVariable("institucionFormadoraId") Long institucionFormadoraId) {
		return convenioService.findConvenioListByInstitucionFormadoraId(institucionFormadoraId);
	}

	@ApiOperation(value = "Listar convenios asociados a una Institucion Formadora filtrados por estado",
			notes = "Retorna todos los convenios asociados a una Institucion Formadora correspondientes al estado indicado")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Lista de relaciones entre Instituci??n y Responsables con estado se??alado"), })
	@GetMapping(INSTITUCION_FORMADORA_PATH + "/{institucionFormadoraId}/" + CONVENIO_PATH + "/estado={estado}")
	public List<Convenio> findConveniosByInstitucionFormadoraIdAndEstado(
			@ApiParam("Estado") @PathVariable String estado,
			@ApiParam("ID Instituci??n Formadora") @PathVariable("institucionFormadoraId") Long institucionFormadoraId
	) {
		return convenioService.findConveniosByInstitucionFormadoraIdAndEstado(institucionFormadoraId, estado);
	}

	//Responsable de Establecimiento
	@Secured({"ROLE_ADMIN", "ROLE_DNERHS"})
	@PostMapping(value = INSTITUCION_ESTABLECIMIENTO_PATH + "/" + RESPONSABLE_PATH , consumes =  MediaType.APPLICATION_JSON_VALUE)
	public ResponsableEstablecimiento saveResponsableEstablecimiento(
			@ApiParam("Responsable Establecimiento") @RequestBody @Valid ResponsableEstablecimiento responsableEstablecimiento) {

		responsableEstablecimientoService.save(responsableEstablecimiento);

		//Creaci??n de usuario
		Usuario usuarioResposanbleEstalecimiento = new Usuario();
		usuarioResposanbleEstalecimiento.setUsername(responsableEstablecimiento.getCedulaIdentidad().toString());
		usuarioResposanbleEstalecimiento.setPassword(bcryptEncoder.encode(responsableEstablecimiento.getCedulaIdentidad().toString()));
		usuarioResposanbleEstalecimiento.setRole(roleService.findByDescripcion("ROLE_RESPONSABLE_ESTABLECIMIENTO"));
		usuarioService.save(usuarioResposanbleEstalecimiento);

		return responsableEstablecimiento;
	}

	@GetMapping(value = INSTITUCION_ESTABLECIMIENTO_PATH + "/" + RESPONSABLE_PATH + "/{id}")
	public Optional<ResponsableEstablecimiento> findResponsableEstablecimientoById(
			@ApiParam("Id Responsable") @PathVariable Long id) {
		return responsableEstablecimientoService.findById(id);
	}

	@Secured({"ROLE_RESPONSABLE_ESTABLECIMIENTO"})
	@GetMapping(value = INSTITUCION_ESTABLECIMIENTO_PATH + "/" + RESPONSABLE_PATH + "/info")
	public Optional<InstitucionEstablecimiento> getInfoResponsable() {

		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = userDetails.getUsername();
		//Usuario usuario = usuarioService.findByUsername(username);

		//ResponsableEstablecimiento responsableEstablecimiento = responsableEstablecimientoService.findById(Long.valueOf(1)).get();
		List<ResponsableEstablecimiento> responsableEstablecimiento = responsableEstablecimientoService.findByCedulaIdentidad(Integer.parseInt(username));

		return institucionEstablecimientoService.findById(responsableEstablecimiento.get(0).getInstitucionEstablecimiento().getId());
	}

	@GetMapping(value = INSTITUCION_ESTABLECIMIENTO_PATH + "/" + RESPONSABLE_PATH)
	public List<ResponsableEstablecimiento> findAllResponsableEstablecimiento() {
		return responsableEstablecimientoService.findAll();
	}

	@PutMapping(value = INSTITUCION_ESTABLECIMIENTO_PATH + "/" + RESPONSABLE_PATH, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponsableEstablecimiento updateResponsableEstablecimiento(
			@ApiParam("Responsable Establecimiento") @RequestBody @Valid ResponsableEstablecimiento responsable){
		return responsableEstablecimientoService.update(responsable);
	}

	@DeleteMapping(value = INSTITUCION_ESTABLECIMIENTO_PATH + "/" + RESPONSABLE_PATH + "/{id}")
	public void deleteResponsableEstablecimiento(
			@ApiParam("Id Responsable Establecimiento") @PathVariable Long id){
		responsableEstablecimientoService.delete(id);
	}

	// Establecimientos

	@Secured({"ROLE_ADMIN", "ROLE_DNERHS", "ROLE_USER", "ROLE_RESPONSABLE_ESTABLECIMIENTO"})
	@ApiOperation(value = "Listar instituciones establecimientos", notes = "Lista las instituciones establecimientos registrados o vacio si no hay registros")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Lista de instituciones establecimientos"), })
	@GetMapping(INSTITUCION_ESTABLECIMIENTO_PATH)
	public List<InstitucionEstablecimiento> findAllInstitucionEstablecimientos() {
		return institucionEstablecimientoService.findAll();
	}

	@ApiOperation(value = "Obtener institucion establecimiento por ID", notes = "Retorna una instituci??n establecimiento dado su ID")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Institucion Establecimiento"),
			@ApiResponse(code = 404, message = "No se encontr?? Institucion Establecimiento") })
	@GetMapping(INSTITUCION_ESTABLECIMIENTO_PATH + "/{id}")
	public Optional<InstitucionEstablecimiento> findInstitucionEstablecimientoById(
			@ApiParam("ID Instituci??n Establecimiento") @PathVariable("id") Long id) {

		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        String username = userDetails.getUsername();
		Usuario usuario = usuarioService.findByUsername(username);
		if (usuario.getRole().equals(roleService.findByDescripcion("ROLE_RESPONSABLE_ESTABLECIMIENTO"))){
			ResponsableEstablecimiento responsableEstablecimiento = responsableEstablecimientoService.findById(Long.valueOf(1)).get();
			return institucionEstablecimientoService.findById(responsableEstablecimiento.getInstitucionEstablecimiento().getId());
		}

		return institucionEstablecimientoService.findById(id);
	}

	@ApiOperation(value = "Paginar instuticiones establecimiento", notes = "Retorna una lista paginada de instituciones establecimiento")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Lista paginada de instituciones establecimiento"), })
	@GetMapping(INSTITUCION_ESTABLECIMIENTO_PATH + "/page")
	public Page<InstitucionEstablecimiento> getPageInstitucionEstablecimiento(
			@ApiParam("N??mero de P??gina") @RequestParam(value = "page", defaultValue = "0", required = false) Integer page,
			@ApiParam("Tama??o de p??gina") @RequestParam(value = "pageSize", defaultValue = "10", required = false) Integer pageSize) {
		return institucionEstablecimientoService.getPage(PageRequest.of(page, pageSize));
	}

	@ApiOperation(value = "Crear instituci??n establecimiento", notes = "Guarda los datos de una nueva instituci??n establecimiento")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Nueva Instituci??n Establecimiento"), })
	@PostMapping(value = INSTITUCION_ESTABLECIMIENTO_PATH, consumes =  MediaType.APPLICATION_JSON_VALUE)
	public InstitucionEstablecimiento saveInstitucionEstablecimiento(
			@ApiParam("Nueva Institucion Establecimiento ") @RequestBody @Valid InstitucionEstablecimiento institucionEstablecimiento) {
		return institucionEstablecimientoService.save(institucionEstablecimiento);
	}

	@ApiOperation(value = "Actualizar instituci??n establecimiento", notes = "Actualiza los datos de una instituci??n establecimiento")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Instituci??n Establecimiento actualizado"), })
	@PutMapping(value = INSTITUCION_ESTABLECIMIENTO_PATH,consumes =  MediaType.APPLICATION_JSON_VALUE)
	public InstitucionEstablecimiento updateInstitucionEstablecimiento(
			@ApiParam("Institucion Establecimiento") @RequestBody @Valid InstitucionEstablecimiento institucionEstablecimiento) {
		return institucionEstablecimientoService.update(institucionEstablecimiento);
	}

	@ApiOperation(value = "Eliminar instituci??n establecimiento", notes = "Elimina los datos de una instituci??n establecimiento")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Instituci??n Establecimiento eliminado"), })
	@DeleteMapping(INSTITUCION_ESTABLECIMIENTO_PATH + "/{id}")
	public void deleteInstitucionEstablecimiento(@ApiParam("ID Instituci??n Establecimiento") @PathVariable Long id) {
		institucionEstablecimientoService.delete(id);
	}

	// Datos de Establecimiento

	@PostMapping(value = INSTITUCION_ESTABLECIMIENTO_PATH + "/" + DATOS_PATH, consumes = MediaType.APPLICATION_JSON_VALUE)
	public DatosEstablecimiento saveDatosEstablecimiento(
			@RequestBody @Valid DatosEstablecimiento datosEstablecimiento){
		return datosEstablecimientoService.save(datosEstablecimiento);
	}

	@PutMapping(value = INSTITUCION_ESTABLECIMIENTO_PATH + "/" + DATOS_PATH, consumes = MediaType.APPLICATION_JSON_VALUE)
	public DatosEstablecimiento updateDatosEstablecimiento(
			@RequestBody @Valid DatosEstablecimiento datosEstablecimiento){
		return datosEstablecimientoService.update(datosEstablecimiento);
	}

	@GetMapping(INSTITUCION_ESTABLECIMIENTO_PATH + "/{establecimientoId}/" + DATOS_PATH)
	public Optional<DatosEstablecimiento> findDatosEstablecimientoByEstablecimientoId(@PathVariable Long establecimientoId){
		return datosEstablecimientoService.findByInstitucionEstablecimientoId(establecimientoId);
	}

	@GetMapping(INSTITUCION_ESTABLECIMIENTO_PATH + "/" + DATOS_PATH + "/{id}" )
	public Optional<DatosEstablecimiento> findDatosEstablecimientoById(@PathVariable Long id){
		return datosEstablecimientoService.findById(id);
	}

	@GetMapping(INSTITUCION_ESTABLECIMIENTO_PATH + "/" + REGION_SANITARIA_PATH + "/{id}" )
	public List<DatosEstablecimiento> findDatosRegionSanitariaById(@PathVariable Long id){
		return datosEstablecimientoService.findByRegionSanitariaId(id);
	}

	@DeleteMapping(INSTITUCION_ESTABLECIMIENTO_PATH + "/" + DATOS_PATH + "/{id}")
	public void deleteDatosEstablecimiento(@PathVariable Long id){
		datosEstablecimientoService.delete(id);
	}

	// Encargado de Establecimiento

	@PostMapping(value = INSTITUCION_ESTABLECIMIENTO_PATH + "/" + ENCARGADO_PATH, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Encargado saveEncargado(
			@RequestBody @Valid Encargado encargado){
		return encargadoService.save(encargado);
	}

	@PutMapping(value = INSTITUCION_ESTABLECIMIENTO_PATH + "/" + ENCARGADO_PATH, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Encargado updateEncargado(
			@RequestBody @Valid Encargado encargado){
		return encargadoService.update(encargado);
	}

	@GetMapping(INSTITUCION_ESTABLECIMIENTO_PATH + "/{establecimientoId}/" + ENCARGADO_PATH)
	public Optional<Encargado> findEncargadoByEstablecimientoId(@PathVariable Long establecimientoId){
		return encargadoService.findByInstitucionEstablecimientoId(establecimientoId);
	}

	@GetMapping(INSTITUCION_ESTABLECIMIENTO_PATH + "/" + ENCARGADO_PATH + "/{id}" )
	public Optional<Encargado> findEncargadoById(@PathVariable Long id){
		return encargadoService.findById(id);
	}

	@DeleteMapping(INSTITUCION_ESTABLECIMIENTO_PATH + "/" + ENCARGADO_PATH + "/{id}")
	public void deleteEncargado(@PathVariable Long id){
		encargadoService.delete(id);
	}

	// Infraestructura

	@PostMapping(value = INSTITUCION_ESTABLECIMIENTO_PATH + "/" + INFRAESTRUCTURA_PATH, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Infraestructura saveInfraestructura(
			@RequestBody @Valid Infraestructura infraestructura){
		return infraestructuraService.save(infraestructura);
	}

	@PutMapping(value = INSTITUCION_ESTABLECIMIENTO_PATH + "/" + INFRAESTRUCTURA_PATH, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Infraestructura updateInfraestructura(
			@RequestBody @Valid Infraestructura infraestructura){
		return infraestructuraService.update(infraestructura);
	}

	@GetMapping(INSTITUCION_ESTABLECIMIENTO_PATH + "/{establecimientoId}/" + INFRAESTRUCTURA_PATH)
	public Optional<Infraestructura> findInfraestructuraByEstablecimientoId(@PathVariable Long establecimientoId){
		return infraestructuraService.findByInstitucionEstablecimientoId(establecimientoId);
	}

	@GetMapping(INSTITUCION_ESTABLECIMIENTO_PATH + "/" + INFRAESTRUCTURA_PATH + "/{id}" )
	public Optional<Infraestructura> findInfraestructuraById(@PathVariable Long id){
		return infraestructuraService.findById(id);
	}

	@DeleteMapping(INSTITUCION_ESTABLECIMIENTO_PATH + "/" + INFRAESTRUCTURA_PATH + "/{id}")
	public void deleteInfraestructura(@PathVariable Long id){
		infraestructuraService.delete(id);
	}

	// Profesionales de Salud

	@PostMapping(value = INSTITUCION_ESTABLECIMIENTO_PATH + "/" + PROFESIONALES_PATH, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ProfesionalesSalud saveProfesionalesSalud(
			@RequestBody @Valid ProfesionalesSalud profesionalesSalud){
		return profesionalesSaludService.save(profesionalesSalud);
	}

	@PutMapping(value = INSTITUCION_ESTABLECIMIENTO_PATH + "/" + PROFESIONALES_PATH, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ProfesionalesSalud updateProfesionalesSalud(
			@RequestBody @Valid ProfesionalesSalud profesionalesSalud){
		return profesionalesSaludService.update(profesionalesSalud);
	}

	@GetMapping(INSTITUCION_ESTABLECIMIENTO_PATH + "/{establecimientoId}/" + PROFESIONALES_PATH)
	public Optional<ProfesionalesSalud> findProfesionalesSaludByEstablecimientoId(@PathVariable Long establecimientoId){
		return profesionalesSaludService.findByInstitucionEstablecimientoId(establecimientoId);
	}

	@GetMapping(INSTITUCION_ESTABLECIMIENTO_PATH + "/" + PROFESIONALES_PATH + "/{id}" )
	public Optional<ProfesionalesSalud> findProfesionalesSaludById(@PathVariable Long id){
		return profesionalesSaludService.findById(id);
	}

	@DeleteMapping(INSTITUCION_ESTABLECIMIENTO_PATH + "/" + PROFESIONALES_PATH + "/{id}")
	public void deleteProfesionalesSalud(@PathVariable Long id){
		profesionalesSaludService.delete(id);
	}

	// Servicios

	@PostMapping(value = INSTITUCION_ESTABLECIMIENTO_PATH + "/" + SERVICIOS_PATH, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Servicios saveServicios(
			@RequestBody @Valid Servicios servicios){
		return serviciosService.save(servicios);
	}

	@PutMapping(value = INSTITUCION_ESTABLECIMIENTO_PATH + "/" + SERVICIOS_PATH, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Servicios updateServicios(
			@RequestBody @Valid Servicios servicios){
		return serviciosService.update(servicios);
	}

	@GetMapping(INSTITUCION_ESTABLECIMIENTO_PATH + "/{establecimientoId}/" + SERVICIOS_PATH)
	public Optional<Servicios> findServiciosByEstablecimientoId(@PathVariable Long establecimientoId){
		return serviciosService.findByInstitucionEstablecimientoId(establecimientoId);
	}

	@GetMapping(INSTITUCION_ESTABLECIMIENTO_PATH + "/" + SERVICIOS_PATH + "/{id}" )
	public Optional<Servicios> findServiciosById(@PathVariable Long id){
		return serviciosService.findById(id);
	}

	@DeleteMapping(INSTITUCION_ESTABLECIMIENTO_PATH + "/" + SERVICIOS_PATH + "/{id}")
	public void deleteServicios(@PathVariable Long id){
		serviciosService.delete(id);
	}

	// Plazas

	@PostMapping(value = INSTITUCION_ESTABLECIMIENTO_PATH + "/" + PLAZAS_PATH, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Plazas savePlazas(
			@RequestBody @Valid Plazas plazas){
		return plazasService.save(plazas);
	}

	@PutMapping(value = INSTITUCION_ESTABLECIMIENTO_PATH + "/" + PLAZAS_PATH, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Plazas updatePlazas(
			@RequestBody @Valid Plazas plazas){
		return plazasService.update(plazas);
	}

	@GetMapping(INSTITUCION_ESTABLECIMIENTO_PATH + "/{establecimientoId}/" + PLAZAS_PATH)
	public Optional<Plazas> findPlazasByEstablecimientoId(@PathVariable Long establecimientoId){
		return plazasService.findByInstitucionEstablecimientoId(establecimientoId);
	}

	@GetMapping(INSTITUCION_ESTABLECIMIENTO_PATH + "/" + PLAZAS_PATH + "/{id}" )
	public Optional<Plazas> findPlazasById(@PathVariable Long id){
		return plazasService.findById(id);
	}

	@DeleteMapping(INSTITUCION_ESTABLECIMIENTO_PATH + "/" + PLAZAS_PATH + "/{id}")
	public void deletePlazas(@PathVariable Long id){
		plazasService.delete(id);
	}


	//Pr??cticas por establecimiento

	@GetMapping(INSTITUCION_ESTABLECIMIENTO_PATH + "/{establecimientoId}/" + "practicas")
	public List<PracticaEstudianteDTO> findPracticaDetalleListByEstablecimientoId (
			@PathVariable Long establecimientoId){

		List<PracticaEstudianteDTO> practicaEstudianteDTOList = new ArrayList<>();
		List<PracticaDetalle> practicaDetalleList = practicaDetalleService.findByEstablecimientoId(establecimientoId);

		for (PracticaDetalle pd : practicaDetalleList){
			PracticaEstudianteDTO practicaEstudianteDTO = new PracticaEstudianteDTO();
			practicaEstudianteDTO.setPractica(practicaService.findById(practicaDetalleService.getPracticaId(pd.getId())).get());
			practicaEstudianteDTO.setPracticaDetalle(pd);
			practicaEstudianteDTOList.add(practicaEstudianteDTO);
		}

		return practicaEstudianteDTOList;

	}

	@GetMapping(INSTITUCION_ESTABLECIMIENTO_PATH + "/{establecimientoId}/" + "practicas/page")
	public List<PracticaDetalle> findPracticaDetalleListByEstablecimientoId (
			@PathVariable Long establecimientoId,
			@ApiParam("N??mero de P??gina") @RequestParam(value = "page", defaultValue = "0", required = false) Integer page,
			@ApiParam("Tama??o de p??gina") @RequestParam(value = "pageSize", defaultValue = "10", required = false) Integer pageSize
	){
		return practicaDetalleService.findByEstablecimientoId(establecimientoId, PageRequest.of(page, pageSize));
	}



}
