package py.gov.mspbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import py.gov.mspbs.entity.*;
import py.gov.mspbs.repository.ConstanciaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional(readOnly = true)
public class ConstanciaService {

    @Autowired
    private ConstanciaRepository constanciaRepository;

    @Autowired
    private ConvenioPracticaService convenioPracticaService;

    @Autowired
    private ConvenioCarreraProgramaService convenioCarreraProgramaService;

    @Autowired
    private ConvenioService convenioService;

    public List<ConstanciaDetalle> findAllPracticas (Long carreraId, Integer cedula, Long formadoraId) {

        List <ConstanciaDetalle> constanciaDetalleList = new ArrayList<>();

        List<Convenio> convenioList = convenioService.findConvenioListByInstitucionFormadoraId(formadoraId);

        List<Practica> practicaList = new ArrayList<>();
        for (Convenio convenio : convenioList){
            practicaList.addAll(convenioPracticaService.findByConvenioId(convenio.getId()));
        }

        for (Practica practica : practicaList){
            if (practica.getConvenioCarrera().getCarreraPrograma().getId().equals(carreraId)){
                List<PracticaDetalle> practicaDetalleList = practica.getPracticaDetalleList();
                if (!practicaDetalleList.isEmpty()){
                    for (PracticaDetalle practicaDetalle : practicaDetalleList){
                        Estudiante estudiante = practicaDetalle.getConvenioEstudiante().getEstudiante();

                        if (estudiante.getCedulaIdentidad().equals(cedula) &&
                                practicaDetalle.getConfirmacion() != null && practicaDetalle.getConfirmacion()
                        ){

                            ConstanciaDetalle constanciaDetalle = new ConstanciaDetalle();
                            constanciaDetalle.setConvenioCarrera(practica.getConvenioCarrera());
                            constanciaDetalle.setCurso(practica.getCurso());
                            constanciaDetalle.setMateria(practica.getMateria());
                            constanciaDetalle.setSemestre(practica.getSemestre());
                            constanciaDetalle.setPracticaDetalle(practicaDetalle);

                            constanciaDetalleList.add(constanciaDetalle);

                        }
                    }
                }

            }
        }
        return constanciaDetalleList;
    }

    @Transactional
    public Constancia save(Constancia constancia) {
        return constanciaRepository.save(constancia);
    }

    @Transactional
    public Constancia update(Constancia constancia) {
        return constanciaRepository.save(constancia);
    }

    @Transactional
    public void delete(Long id) {
        constanciaRepository.deleteById(id);
    }

    public Optional<Constancia> findById(@PathVariable("id") Long id) {
        return constanciaRepository.findById(id);
    }

    public List<Constancia> findAllByCedulaIdentidad(Integer cedula){
        return constanciaRepository.findAllByCedulaIdentidad(cedula);
    }


}


