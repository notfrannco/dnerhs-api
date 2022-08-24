package py.gov.mspbs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import py.gov.mspbs.entity.InstitucionFormadora;
import py.gov.mspbs.entity.InstitucionFormadoraResponsableMaximaAutoridad;
import py.gov.mspbs.entity.Usuario;
import py.gov.mspbs.repository.InstitucionFormadoraRepository;

@Service
@Transactional(readOnly = true)
public class InstitucionFormadoraService {

	@Autowired
	private InstitucionFormadoraRepository institucionRepository;

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private InstitucionFormadoraResponsableMaximaAutoridadService institucionFormadoraResponsableMaximaAutoridadService;
	
	public List<InstitucionFormadora> findAll() {
		return institucionRepository.findAll();
	}
	
	public Page<InstitucionFormadora> getPage(Pageable pageable) {
		return institucionRepository.findAll(pageable);
	}
	
	public Optional<InstitucionFormadora> findById(@PathVariable("id") Long id) {
		return institucionRepository.findById(id);
	}
	
	@Transactional
	public InstitucionFormadora save(InstitucionFormadora institucionFormadora) {
		return institucionRepository.save(institucionFormadora);
	}
	
	@Transactional
	public InstitucionFormadora update(InstitucionFormadora institucionFormadora) {
		return institucionRepository.save(institucionFormadora);
		
	}

	@Transactional
	public void delete(Long id) {
		institucionRepository.deleteById(id);
	}

	public Boolean hasPermission (Long formadoraId) {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        Usuario usuario = usuarioService.findByUsername(userDetails.getUsername());
		System.out.println("Comprobación de permisos usuario = " + userDetails.getUsername());
		if (usuario.getRole() != null){
			if (usuario.getRole().getDescripcion().equals("ROLE_ADMIN") ||usuario.getRole().equals("ROL_DNERHS") ){
				return true;
			}
			if (usuario.getRole().getDescripcion().equals("ROLE_USER")){
				List<InstitucionFormadoraResponsableMaximaAutoridad> instituciones =
						usuario.getInstitucionFormadoraResponsableMaximaAutoridadList();
				for (InstitucionFormadoraResponsableMaximaAutoridad ifma : instituciones){
					if (ifma.getFormadora().getId() == formadoraId) {
						return true;
					}
				}
			}
		}
		return false;
	}

}
