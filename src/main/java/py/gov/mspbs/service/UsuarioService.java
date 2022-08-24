package py.gov.mspbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import py.gov.mspbs.entity.Responsable;
import py.gov.mspbs.entity.Usuario;
import py.gov.mspbs.repository.UsuarioRepository;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public Optional<Usuario> findById(@PathVariable("id") Long id) {
        return usuarioRepository.findById(id);
    }

    public Usuario findByUsername(@PathVariable("username") String username) {
        return usuarioRepository.findByUsername(username);
    }

    @Transactional
    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Transactional
    public Usuario update(Usuario usuario) {
        return usuarioRepository.save(usuario);

    }
}
