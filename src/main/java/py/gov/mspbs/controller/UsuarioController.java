package py.gov.mspbs.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import py.gov.mspbs.entity.Usuario;
import py.gov.mspbs.model.JwtRequest;
import py.gov.mspbs.model.UsuarioData;
import py.gov.mspbs.service.UsuarioService;
import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    private PasswordEncoder bcryptEncoder;


    @ApiOperation(value = "Actualizar contraseña de usuario", notes = "Actualiza contraseña de un usuario")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Contraseña de usuario actualizado"), })
    @PostMapping(value="{id}/actualizar-password", consumes =  MediaType.APPLICATION_JSON_VALUE)
    Usuario updatePassword(@ApiParam("ID Usuario") @PathVariable Long id,
                           @RequestBody @Valid JwtRequest authentication) {

        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        String username = userDetails.getUsername();

        Optional<Usuario> usuario = usuarioService.findById(id);

        //|| usuario.get().getRole().getDescripcion().equals("ROLE_ADMIN")
        if (usuario.isPresent() && usuario.get().getUsername().equals(username)){
            usuario.get().setPassword(bcryptEncoder.encode(authentication.getPassword()));
        }
        return usuarioService.update(usuario.get());
    }


    @ApiOperation(value = "Crear usuario", notes = "Guarda los datos de un nuevo usuario")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Nuevo usuario"), })
    @PostMapping(consumes =  MediaType.APPLICATION_JSON_VALUE)
    Usuario save(@ApiParam("Nuevo Usuario")  @RequestBody UsuarioData usuarioData){
        usuarioData.getUsuario().setPassword(bcryptEncoder.encode(usuarioData.getPassword()));
        return usuarioService.save(usuarioData.getUsuario());
    }

    @ApiOperation(value = "Obtener un usuario por ID", notes = "Retorna un usuario dado su ID")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Usuario"),
            @ApiResponse(code = 404, message = "No se encontró el usuario") })
    @GetMapping("{id}")
    Optional<Usuario> findById(@ApiParam("ID Usuario") @PathVariable("id") Long id) {
        return usuarioService.findById(id);
    }

}
