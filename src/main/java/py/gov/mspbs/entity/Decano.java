package py.gov.mspbs.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "decano")
public class Decano extends AuditBaseEntity implements Serializable {

    private static final long serialVersionUID = 4458532095743280161L;

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

    private String profesion;

    private String fotocopiaCedula;

    private String titulosGrado;

    private String titulosPosgrado;

    private String carrera;

    public Persona getPersona() {
        return persona;
    }
    public void setPersona(Persona persona) {
        this.persona = persona;
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

    public String getCarrera() {
        return carrera;
    }
    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
}
