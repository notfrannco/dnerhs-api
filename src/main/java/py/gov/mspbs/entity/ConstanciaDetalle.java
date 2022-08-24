package py.gov.mspbs.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "constancia_detalle")
public class ConstanciaDetalle implements Serializable {
    private static final long serialVersionUID = -5178005130295407521L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull(message = "El campo carrera es requerido")
    @ManyToOne
    @JoinColumn(name = "convenio_carreraprograma_id")
    private ConvenioCarreraPrograma convenioCarrera;

    @NotNull(message = "El campo Materia es requerido")
    private String materia;

    @NotNull(message = "El campo Curso es requerido")
    private Integer curso;

    @NotNull(message = "El campo Semestre es requerido")
    private Integer semestre;

    //@NotNull(message = "El campo Detalle de Práctica es requerido")
    @OneToOne
    @JoinColumn(name = "practica_id")
    private PracticaDetalle practicaDetalle;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ConvenioCarreraPrograma getConvenioCarrera() {
        return convenioCarrera;
    }

    public void setConvenioCarrera(ConvenioCarreraPrograma convenioCarrera) {
        this.convenioCarrera = convenioCarrera;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public Integer getCurso() {
        return curso;
    }

    public void setCurso(Integer curso) {
        this.curso = curso;
    }

    public Integer getSemestre() {
        return semestre;
    }

    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
    }

    public PracticaDetalle getPracticaDetalle() {
        return practicaDetalle;
    }

    public void setPracticaDetalle(PracticaDetalle practicaDetalle) {
        this.practicaDetalle = practicaDetalle;
    }
}
