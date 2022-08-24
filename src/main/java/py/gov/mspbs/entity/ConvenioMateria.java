package py.gov.mspbs.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "convenio_materia")
public class ConvenioMateria extends AuditBaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "convenio_id", nullable = false)
    private Convenio convenio;

    @ManyToOne
    @JoinColumn(name = "convenio_carreraprograma_id")
    private ConvenioCarreraPrograma convenioCarreraPrograma;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "materia_id")
    private Materia materia;

    public ConvenioCarreraPrograma getConvenioCarreraPrograma() {
        return convenioCarreraPrograma;
    }
    public void setConvenioCarreraPrograma(ConvenioCarreraPrograma convenioCarreraPrograma) {
        this.convenioCarreraPrograma = convenioCarreraPrograma;
    }

    public Materia getMateria() {
        return materia;
    }
    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public Convenio getConvenio() {
        return convenio;
    }
    public void setConvenio(Convenio convenio) {
        this.convenio = convenio;
    }
}
