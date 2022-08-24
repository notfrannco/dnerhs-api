package py.gov.mspbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import py.gov.mspbs.entity.NombreServicio;
import py.gov.mspbs.repository.NombreServicioRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class NombreServicioService {

    @Autowired
    private NombreServicioRepository nombreServicioRepository;

    public List<NombreServicio> findAll(){
        return nombreServicioRepository.findAll();
    }

}
