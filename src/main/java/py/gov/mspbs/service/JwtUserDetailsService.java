package py.gov.mspbs.service;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import py.gov.mspbs.entity.Usuario;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        List<SimpleGrantedAuthority> roles;

        Usuario user = usuarioService.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Usuario no encontrado: " + username);
        }
        roles = Arrays.asList(new SimpleGrantedAuthority(user.getRole().getDescripcion()));
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                roles);
    }

}
