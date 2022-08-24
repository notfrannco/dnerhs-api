package py.gov.mspbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import py.gov.mspbs.entity.ConvenioDocumentosRespaldo;

import java.util.List;

public interface ConvenioDocumentosRespaldoRepository extends JpaRepository<ConvenioDocumentosRespaldo, Long> {

    ConvenioDocumentosRespaldo findByConvenioId(Long convenioId);

}
