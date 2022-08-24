package py.gov.mspbs.entity;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import java.io.Serializable;

@Entity
@Table(name = "convenio_estudiante")
public class ConvenioEstudiante extends AuditBaseEntity implements Serializable {

    private static final long serialVersionUID = -1544905379850182579L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @ManyToOne
    @JoinColumn(name = "convenio_id", nullable = false)
    private Convenio convenio;

    @Valid
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "estudiante_id")
    private Estudiante estudiante;


    public Estudiante getEstudiante() {
        return estudiante;
    }
    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Convenio getConvenio() {
        return convenio;
    }
    public void setConvenio(Convenio convenio) {
        this.convenio = convenio;
    }
}
