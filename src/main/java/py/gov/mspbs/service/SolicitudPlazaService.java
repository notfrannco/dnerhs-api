package py.gov.mspbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import py.gov.mspbs.entity.Convenio;
import py.gov.mspbs.entity.DatosEstablecimiento;
import py.gov.mspbs.entity.EstablecimientosCarrerasPlazas;
import py.gov.mspbs.entity.InstitucionFormadora;
import py.gov.mspbs.entity.InstitucionFormadoraResponsableMaximaAutoridad;
import py.gov.mspbs.entity.SolicitudPlaza;
import py.gov.mspbs.entity.SolicitudPlazaObservacion;
import py.gov.mspbs.entity.Usuario;
import py.gov.mspbs.repository.SolicitudPlazaRepository;
import py.gov.mspbs.repository.EstablecimientosCarrerasPlazasRepository;
import py.gov.mspbs.repository.InstitucionFormadoraRepository;
import py.gov.mspbs.repository.SolicitudPlazaObservacionRepository;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class SolicitudPlazaService {

    @Autowired
    private SolicitudPlazaRepository solicitudPlazaRepository;

    @Autowired
    private EstablecimientosCarrerasPlazasRepository establecimientosCarrerasPlazasRepository;

    @Autowired
    private InstitucionFormadoraRepository institucionFormadoraRepository;

    @Autowired
    private SolicitudPlazaObservacionRepository solicitudPlazaObservacionRepository;

    @Autowired
    private EstablecimientosCarrerasPlazasService establecimientosCarrerasPlazasService;

    public List<SolicitudPlaza> findAll() {
        return solicitudPlazaRepository.findAll();
    }

    @Autowired
	private UsuarioService usuarioService;

    public Page<SolicitudPlaza> getPage(Long datosEstablecimientoId, Long convenioId, Pageable pageable) {
        DatosEstablecimiento datosEstablecimiento = new DatosEstablecimiento();
        datosEstablecimiento.setId(datosEstablecimientoId);
        Convenio convenio = new Convenio();
        convenio.setId(convenioId);
        if(datosEstablecimientoId == 0 && convenioId == 0){
            return solicitudPlazaRepository.findAll(pageable);
        } else if(datosEstablecimientoId != 0 && convenioId == 0){
            return solicitudPlazaRepository.findByDatosEstablecimiento(datosEstablecimiento, pageable);
        } else if(datosEstablecimientoId == 0 && convenioId != 0){
            return solicitudPlazaRepository.findByConvenio(convenio, pageable);
        } else {
            return solicitudPlazaRepository.findByDatosEstablecimientoAndConvenio(datosEstablecimiento, convenio, pageable);
        }
    }

    public Optional<SolicitudPlaza> getAprobadas() {
        Long institucionFormadorId = Long.valueOf(0);
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Usuario usuario = usuarioService.findByUsername(userDetails.getUsername());
		System.out.println("Comprobación de permisos usuario = " + userDetails.getUsername());
        List<InstitucionFormadoraResponsableMaximaAutoridad> instituciones = usuario.getInstitucionFormadoraResponsableMaximaAutoridadList();
		for (InstitucionFormadoraResponsableMaximaAutoridad ifma : instituciones){
            System.out.println("--> ifma = " + ifma.getResponsable().getCedulaIdentidad());
            if(userDetails.getUsername().equals(ifma.getResponsable().getCedulaIdentidad().toString())){
                System.out.println("--> ifma = SON IGUALES");
                institucionFormadorId = Long.valueOf(ifma.getFormadora().getId());
            }
            
		}
        return solicitudPlazaRepository.findByEstadoAndConvenio_InstitucionFormadoraId("Aprobada por DNERHS",institucionFormadorId);
    }

    public Optional<SolicitudPlaza> findById(@PathVariable("id") Long id) {
        return solicitudPlazaRepository.findById(id);
    }

    public List<SolicitudPlaza> findByConvenio_InstitucionFormadoraIdAndCarreraprogramaId(@PathVariable("idFormadora") Long idFormadora, @PathVariable("idCarrera") Long idCarrera) {
        return solicitudPlazaRepository.findByConvenio_InstitucionFormadoraIdAndCarreraprogramaId(idFormadora, idCarrera);
    }

    @Transactional
    public SolicitudPlaza save(SolicitudPlaza solicitudPlaza) {
        Long datosEstablecimientoId = solicitudPlaza.getDatosEstablecimiento().getId();
        Long carreraprogramaId = solicitudPlaza.getCarreraprograma().getId();
        Integer lugaresSolicitados = solicitudPlaza.getLugaresSolicitados();

        EstablecimientosCarrerasPlazas establecimientosCarrerasPlazas = establecimientosCarrerasPlazasService.findByNombreServicioIdAndCarreraprogramaId(datosEstablecimientoId, carreraprogramaId).get();

        Integer enGestion = establecimientosCarrerasPlazas.getEnGestion() + lugaresSolicitados;
        Integer disponible = establecimientosCarrerasPlazas.getDisponible() - lugaresSolicitados;

        if (lugaresSolicitados > establecimientosCarrerasPlazas.getDisponible()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cantidad de lugares solicitados no disponible");
        }

        establecimientosCarrerasPlazas.setEnGestion(enGestion);
        establecimientosCarrerasPlazas.setDisponible(disponible);

        establecimientosCarrerasPlazasService.update(establecimientosCarrerasPlazas);

        return solicitudPlazaRepository.save(solicitudPlaza);
    }

    @Transactional
    public SolicitudPlaza updateAprobarRechazar(Long id, String operacion, String observacion) {
        System.out.println("id y operacion -> " + id + " - " + operacion + " - " + observacion);
        
        SolicitudPlaza solicitudPlaza = solicitudPlazaRepository.findById(id).get();
        
        Long idNombreServicio = solicitudPlaza.getDatosEstablecimiento().getInstitucionEstablecimiento().getNombreServicio().getId();
        Long idCarreraprograma = solicitudPlaza.getCarreraprograma().getId();
        Long idInstitucionFormadora = solicitudPlaza.getConvenio().getInstitucionFormadora().getId();

        EstablecimientosCarrerasPlazas establecimientosCarrerasPlazas = establecimientosCarrerasPlazasRepository.findByNombreServicioIdAndCarreraprogramaId(idNombreServicio, idCarreraprograma).get();

        InstitucionFormadora institucionFormadora = institucionFormadoraRepository.findById(idInstitucionFormadora).get();
        Integer cantidad = solicitudPlaza.getLugaresSolicitados();

        String estado = "";
        if(operacion.equals("aprobar")){
            establecimientosCarrerasPlazas.setEnGestion(establecimientosCarrerasPlazas.getEnGestion() - cantidad);
            establecimientosCarrerasPlazas.setOcupadas(establecimientosCarrerasPlazas.getOcupadas() + cantidad);

            institucionFormadora.setAsignadas(institucionFormadora.getAsignadas() + cantidad);

            establecimientosCarrerasPlazasRepository.save(establecimientosCarrerasPlazas);
            institucionFormadoraRepository.save(institucionFormadora);

            estado = "Aprobado por DNERHS";
        } else if(operacion.equals("rechazar")){
            establecimientosCarrerasPlazas.setEnGestion(establecimientosCarrerasPlazas.getEnGestion() - cantidad);
            establecimientosCarrerasPlazas.setDisponible(establecimientosCarrerasPlazas.getDisponible() + cantidad);
            
            SolicitudPlazaObservacion solicitudPlazaObservacion = new SolicitudPlazaObservacion();
            solicitudPlazaObservacion.setFechaObservacion(new Date());
            solicitudPlazaObservacion.setObservacion(observacion);
            solicitudPlazaObservacion.setSolicitudPlaza(solicitudPlaza);

            establecimientosCarrerasPlazasRepository.save(establecimientosCarrerasPlazas);
            solicitudPlazaObservacionRepository.save(solicitudPlazaObservacion);

            estado = "Rechazado por DNERHS";
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Operación incorrecta. Solo se permite aprobar o rechazar");    
        }
                
        solicitudPlaza.setEstado(estado);
        solicitudPlazaRepository.save(solicitudPlaza);

        return solicitudPlaza;
    }

    @Transactional
    public SolicitudPlaza update(SolicitudPlaza solicitudPlaza) {
        return solicitudPlazaRepository.save(solicitudPlaza);
    }

    @Transactional
    public void delete(Long id) {
        solicitudPlazaRepository.deleteById(id);
    }
}
