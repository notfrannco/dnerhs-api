package py.gov.mspbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import py.gov.mspbs.entity.Tutor;

public interface TutorRepository extends JpaRepository<Tutor, Long> {

}
