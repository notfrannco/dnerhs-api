package py.gov.mspbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import py.gov.mspbs.entity.RegionSanitaria;
import py.gov.mspbs.repository.RegionSanitariaRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class RegionSanitariaService {

    @Autowired
    private RegionSanitariaRepository regionSanitariaRepository;

    public List<RegionSanitaria> findAll(){
        return regionSanitariaRepository.findAll();
    }

}
