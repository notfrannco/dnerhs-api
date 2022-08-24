package py.gov.mspbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import py.gov.mspbs.entity.Archivo;
import py.gov.mspbs.repository.ArchivoRepository;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class ArchivoService {

    @Autowired
    ArchivoRepository archivoRepository;

    public Optional<Archivo> findById(@PathVariable("id") String id) {
        return archivoRepository.findById(id);
    }

    @Transactional
    public Archivo save(Archivo archivo) {
        return archivoRepository.save(archivo);
    }

}
