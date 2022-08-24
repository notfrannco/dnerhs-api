package py.gov.mspbs.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import py.gov.mspbs.DnerhsApplication;
import py.gov.mspbs.entity.InstitucionFormadoraResponsableMaximaAutoridad;
import py.gov.mspbs.entity.Responsable;
import py.gov.mspbs.entity.Usuario;
import py.gov.mspbs.service.*;

@RestController
@RequestMapping(value = "/responsables", produces = MediaType.APPLICATION_JSON_VALUE)
public class ResponsableController {

	private static final String PENDIENTE = "Solicitud pendiente de autorización por DNERHS";
	private static final String APROBADA = "Solicitud aprobada por DNERHS";
	private static final String RECHAZADA = "Solicitud rechazada por DNERHS";

	@Autowired
    ResponsableService responsableService;

	@Autowired
	RoleService roleService;

	@Autowired
	UsuarioService usuarioService;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Autowired
	private EmailService emailService;

	@Autowired
	private InstitucionFormadoraResponsableMaximaAutoridadService institucionFormadoraResponsableService;

	@ApiOperation(value = "Listar encargados", notes = "Lista de responsables registrados o vacio si no hay registros")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Lista de encargados"), })
	@GetMapping
	List<Responsable> findAll() {
		return responsableService.findAll();
	}

	@ApiOperation(value = "Obtener un encargado por ID", notes = "Retorna un encargado dado su ID")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Responsable"),
			@ApiResponse(code = 404, message = "No se encontró responsables") })
	@GetMapping("{id}")
	Optional<Responsable> findById(@ApiParam("ID Responsable") @PathVariable("id") Long id) {
		return responsableService.findById(id);
	}

	@ApiOperation(value = "Paginar responsables", notes = "Retorna una lista paginada de responsables")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Lista paginada de responsables"), })
	@GetMapping("page")
	Page<Responsable> getPage(
			@ApiParam("Número de Página") @RequestParam(value = "page", defaultValue = "0", required = false) Integer page,
			@ApiParam("Tamaño de página") @RequestParam(value = "pageSize", defaultValue = "10", required = false) Integer pageSize) {
		return responsableService.getPage(PageRequest.of(page, pageSize));
	}

	@ApiOperation(value = "Crear encargado", notes = "Guarda los datos de un nuevo responsable")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Nuevo Responsable"), })
	@PostMapping(consumes =  MediaType.APPLICATION_JSON_VALUE)
	Responsable save(@ApiParam("Nuevo Encargado") @Valid @RequestBody Responsable responsable) {
		return responsableService.save(responsable);
	}

	@ApiOperation(value = "Actualizar responsable", notes = "Actualiza los datos de un responsable")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Responsable Actualizado"), })
	@PutMapping(consumes =  MediaType.APPLICATION_JSON_VALUE)
	Responsable update(@ApiParam("Responsable") @Valid @RequestBody Responsable responsable) {
		return responsableService.update(responsable);
	}

	@ApiOperation(value = "Eliminar responsable", notes = "Elimina los datos de un responsable")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Responsable Eliminado"), })
	@DeleteMapping("{id}")
	void delete(@ApiParam("ID Responsable") @PathVariable Long id) {
		responsableService.delete(id);
	}

	@ApiOperation(value = "Aprobar/Rechazar responsable y crear un usuario", notes = "Registra la aprobación o el rechazo de un responsable. Crea un usuario para el usuario Aprobado")
	@PostMapping(value = "{id}/aprobacion")
	void createUsaurioFromUsuarioAprobado(
			@ApiParam("ID Responsable") @PathVariable Long id,
			@ApiParam("Estado") @RequestParam(value = "estado", required = true) String estado,
			@ApiParam("Observacíon") @RequestParam(value = "observacion", required = false) String observacion
			){
		Optional<Responsable> responsable = responsableService.findById(id);
		Optional<InstitucionFormadoraResponsableMaximaAutoridad> institucionFormadoraResponsableMaximaAutoridad = Optional.ofNullable(institucionFormadoraResponsableService.findInstitucionFormadoraResponsableByResponsableId(responsable.get().getId()));

		if (institucionFormadoraResponsableMaximaAutoridad.isPresent()){
			institucionFormadoraResponsableMaximaAutoridad.get().setEstado(estado);

			String texto = "";
			if (estado.equals(APROBADA)){

				Usuario usuario = usuarioService.findByUsername(responsable.get().getCedulaIdentidad().toString());

				if (usuario == null){
					usuario = new Usuario();
					usuario.setUsername(responsable.get().getCedulaIdentidad().toString());
					usuario.setPassword(bcryptEncoder.encode(responsable.get().getCedulaIdentidad().toString()));
					usuario.setRole(roleService.findByDescripcion("ROLE_USER"));

					List<InstitucionFormadoraResponsableMaximaAutoridad> institucionFormadoraResponsableMaximaAutoridadList = new ArrayList<>();
					institucionFormadoraResponsableMaximaAutoridadList.add(institucionFormadoraResponsableMaximaAutoridad.get());
					usuario.setInstitucionFormadoraResponsableMaximaAutoridadList(institucionFormadoraResponsableMaximaAutoridadList);

					usuarioService.save(usuario);
				} else {
					List<InstitucionFormadoraResponsableMaximaAutoridad> institucionFormadoraResponsableMaximaAutoridadList = usuario.getInstitucionFormadoraResponsableMaximaAutoridadList();
					institucionFormadoraResponsableMaximaAutoridadList.add(institucionFormadoraResponsableMaximaAutoridad.get());
					usuarioService.update(usuario);
				}

				institucionFormadoraResponsableMaximaAutoridad.get().setObservacion("");
				texto = texto = "Estado de Solicitud: " + estado + ".";

			} else if (estado.equals(RECHAZADA)){
				institucionFormadoraResponsableMaximaAutoridad.get().setObservacion(observacion);
				texto = "Estado de Solicitud: " + estado + ". Motivo del rechazo: " + observacion;
			}
			responsableService.save(responsable.get());
			institucionFormadoraResponsableMaximaAutoridad.get().setFechaRevision(new Date());

			UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        	String username = userDetails.getUsername();
			institucionFormadoraResponsableMaximaAutoridad.get().setUsuarioRevisor(username);

			institucionFormadoraResponsableService.save(institucionFormadoraResponsableMaximaAutoridad.get());

			emailService.sendSimpleMessage(responsable.get().getEmail() + ","
							+ institucionFormadoraResponsableMaximaAutoridad.get().getMaximaAutoridad().getEmail(),
			 "Solicitud de acceso al Sistema DNERHS como Responable de Institucion Formadora", texto);

			System.out.print(texto);

		}

	}
}
