package py.gov.mspbs.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "convenio_carreraprograma")
public class ConvenioCarreraPrograma extends AuditBaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   
    @ManyToOne
    @JoinColumn(name = "convenio_id")
    private Convenio convenio;

    @ManyToOne
    @JoinColumn(name = "carreraprograma_id")
    private CarreraPrograma carreraPrograma;

    @NotNull(message = "El campo Malla curricular es un campo requerido")
    private String mallaCurricular;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Convenio getConvenio() {
        return convenio;
    }

    public void setConvenio(Convenio convenio) {
        this.convenio = convenio;
    }

    public CarreraPrograma getCarreraPrograma() {
        return carreraPrograma;
    }

    public void setCarreraPrograma(CarreraPrograma carreraPrograma) {
        this.carreraPrograma = carreraPrograma;
    }

    public String getMallaCurricular() {
        return mallaCurricular;
    }

    public void setMallaCurricular(String mallaCurricular) {
        this.mallaCurricular = mallaCurricular;
    }
}

