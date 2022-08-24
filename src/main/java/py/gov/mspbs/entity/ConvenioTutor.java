package py.gov.mspbs.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.io.Serializable;

@Entity
@Table(name = "convenio_tutor")
public class ConvenioTutor implements Serializable {

    private static final long serialVersionUID = 2074344016380800054L;

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
    @JoinColumn(name = "convenio_id")
    @NotNull(message = "El campo convenio es un campo requerido")
    private Convenio convenio;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tutor_id")
    @NotNull(message = "El campo tutor es un campo requerido")
    private Tutor tutor;

    public Convenio getConvenio() {
        return convenio;
    }
    public void setConvenio(Convenio convenio) {
        this.convenio = convenio;
    }

    public Tutor getTutor() {
        return tutor;
    }
    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }
}
