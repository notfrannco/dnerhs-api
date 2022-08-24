package py.gov.mspbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import py.gov.mspbs.entity.NivelServicio;
import py.gov.mspbs.repository.NivelServicioRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class NivelServicioService {

    @Autowired
    private NivelServicioRepository nivelServicioRepository;

    public List<NivelServicio> findAll(){
        return nivelServicioRepository.findAll();
    }

}
