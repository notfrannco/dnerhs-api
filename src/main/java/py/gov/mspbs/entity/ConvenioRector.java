package py.gov.mspbs.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "convenio_rector")
public class ConvenioRector extends AuditBaseEntity implements Serializable {

    private static final long serialVersionUID = 7887291513463884032L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "persona_id", nullable = false)
    private Persona persona;

    @OneToOne
    @JoinColumn(name = "convenio_id", nullable = false)
    private Convenio convenio;

    private String direccionRectoria;

    private String profesion;

    private String fotocopiaCedula;

    private String titulosGrado;

    private String titulosPosgrado;

    public Persona getPersona() {
        return persona;
    }
    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Convenio getConvenio() {
        return convenio;
    }
    public void setConvenio(Convenio convenio) {
        this.convenio = convenio;
    }

    public String getDireccionRectoria() {
        return direccionRectoria;
    }
    public void setDireccionRectoria(String direccionRectoria) {
        this.direccionRectoria = direccionRectoria;
    }

    public String getProfesion() {
        return profesion;
    }
    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getFotocopiaCedula() {
        return fotocopiaCedula;
    }
    public void setFotocopiaCedula(String fotocopiaCedula) {
        this.fotocopiaCedula = fotocopiaCedula;
    }

    public String getTitulosGrado() {
        return titulosGrado;
    }
    public void setTitulosGrado(String titulosGrado) {
        this.titulosGrado = titulosGrado;
    }

    public String getTitulosPosgrado() {
        return titulosPosgrado;
    }
    public void setTitulosPosgrado(String titulosPosgrado) {
        this.titulosPosgrado = titulosPosgrado;
    }
}
