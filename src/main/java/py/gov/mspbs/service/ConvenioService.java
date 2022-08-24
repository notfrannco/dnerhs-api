package py.gov.mspbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import py.gov.mspbs.entity.Convenio;
import py.gov.mspbs.entity.InstitucionFormadoraResponsableMaximaAutoridad;
import py.gov.mspbs.entity.Usuario;
import py.gov.mspbs.repository.ConvenioRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class ConvenioService {

    @Autowired
    private ConvenioRepository convenioRepository;

    @Autowired
    private UsuarioService usuarioService;

    public List<Convenio> findAll() {
        return convenioRepository.findAll();
    }

    public Page<Convenio> getPage(Pageable pageable) {
        return convenioRepository.findAll(pageable);
    }

    public Optional<Convenio> findById(@PathVariable("id") Long id) {
        return convenioRepository.findById(id);
    }

    public List<Convenio> findConvenioListByInstitucionFormadoraId(@PathVariable("institucionFormadoraId") Long institucionFormadoraId){
        return convenioRepository.findConvenioListByInstitucionFormadoraId(institucionFormadoraId);
    }

    public List<Convenio> findConveniosByInstitucionFormadoraIdAndEstado(
            @PathVariable("institucionFormadoraId") Long institucionFormadoraId,
            @PathVariable("estado") String estado
            ){
        return convenioRepository.findConveniosByInstitucionFormadoraIdAndEstado(institucionFormadoraId, estado);
    }

    @Transactional
    public Convenio save(Convenio convenio) {
        return convenioRepository.save(convenio);
    }

    @Transactional
    public Convenio update(Convenio convenio) {
        return convenioRepository.save(convenio);
    }

    @Transactional
    public void delete(Long id) {
        convenioRepository.deleteById(id);
    }

    public List<Convenio> findConveniosByEstado(String estado){
        return convenioRepository.findConveniosByEstado(estado);
    }

    public List<Convenio> findConveniosVigentes (String estado) {
        return convenioRepository
                .findConveniosByFechaInicioVigenciaLessThanEqualAndFechaFinVigenciaGreaterThanEqualAndEstado(
                        new Date(), new Date(), estado);
    }

    public Boolean hasPermission (Long convenioId) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        Usuario usuario = usuarioService.findByUsername(userDetails.getUsername());
        System.out.println("Comprobación de permisos usuario = " + userDetails.getUsername());
        if (usuario.getRole() != null){
            if (usuario.getRole().getDescripcion().equals("ROLE_ADMIN") ||usuario.getRole().getDescripcion().equals("ROLE_DNERHS") ){
                return true;
            }
            if (usuario.getRole().getDescripcion().equals("ROLE_USER")){
                List<InstitucionFormadoraResponsableMaximaAutoridad> instituciones =
                        usuario.getInstitucionFormadoraResponsableMaximaAutoridadList();
                for (InstitucionFormadoraResponsableMaximaAutoridad ifma : instituciones){
                    List <Convenio> convenios = this.findConvenioListByInstitucionFormadoraId(ifma.getFormadora().getId());
                    for (Convenio convenio : convenios){
                        if (convenio.getId().equals(convenioId)){
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
