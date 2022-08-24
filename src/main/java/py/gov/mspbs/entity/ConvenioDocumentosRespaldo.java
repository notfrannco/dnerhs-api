package py.gov.mspbs.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "convenio_documentos_respaldo")
public class ConvenioDocumentosRespaldo extends AuditBaseEntity implements Serializable {

    private static final long serialVersionUID = 495931054745831236L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }

    @OneToOne
    @JoinColumn(name = "convenio_id", nullable = false)
    private Convenio convenio;

    private String aneaesCertificadoInicioProceso;

    private String aneaesRespaldoProcesoEvaluacion;

    private String aneaesPlanMejoras;

    private String conesResolucionRegistroOfertasAcademicas;

    private String constanciaGestionConvenio;

    public Convenio getConvenio() {
        return convenio;
    }
    public void setConvenio(Convenio convenio) {
        this.convenio = convenio;
    }

    public String getAneaesCertificadoInicioProceso() {
        return aneaesCertificadoInicioProceso;
    }
    public void setAneaesCertificadoInicioProceso(String aneaesCertificadoInicioProceso) {
        this.aneaesCertificadoInicioProceso = aneaesCertificadoInicioProceso;
    }

    public String getAneaesRespaldoProcesoEvaluacion() {
        return aneaesRespaldoProcesoEvaluacion;
    }
    public void setAneaesRespaldoProcesoEvaluacion(String aneaesRespaldoProcesoEvaluacion) {
        this.aneaesRespaldoProcesoEvaluacion = aneaesRespaldoProcesoEvaluacion;
    }

    public String getAneaesPlanMejoras() {
        return aneaesPlanMejoras;
    }
    public void setAneaesPlanMejoras(String aneaesPlanMejoras) {
        this.aneaesPlanMejoras = aneaesPlanMejoras;
    }

    public String getConesResolucionRegistroOfertasAcademicas() {
        return conesResolucionRegistroOfertasAcademicas;
    }
    public void setConesResolucionRegistroOfertasAcademicas(String conesResolucionRegistroOfertasAcademicas) {
        this.conesResolucionRegistroOfertasAcademicas = conesResolucionRegistroOfertasAcademicas;
    }

    public String getConstanciaGestionConvenio() {
        return constanciaGestionConvenio;
    }
    public void setConstanciaGestionConvenio(String constanciaGestionConvenio) {
        this.constanciaGestionConvenio = constanciaGestionConvenio;
    }
}
