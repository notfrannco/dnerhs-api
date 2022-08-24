package py.gov.mspbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import py.gov.mspbs.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByDescripcion(String descripcion);

}
