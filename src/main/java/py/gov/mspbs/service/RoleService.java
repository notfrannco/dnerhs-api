package py.gov.mspbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import py.gov.mspbs.entity.Role;
import py.gov.mspbs.repository.RoleRepository;

@Service
@Transactional(readOnly = true)
public class RoleService {

    @Autowired
    RoleRepository roleRepository;

    public Role findByDescripcion(String descripcion){
        return roleRepository.findByDescripcion(descripcion);
    }

}
