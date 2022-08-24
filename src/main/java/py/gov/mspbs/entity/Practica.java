package py.gov.mspbs.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "practica")
public class Practica extends AuditBaseEntity implements Serializable {

    private static final long serialVersionUID = 3652576639806730790L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   
    @NotNull(message = "El campo Convenio es requerido")
    @ManyToOne
    @JoinColumn(name = "convenio_id")
    private Convenio convenio;

    @NotNull(message = "El campo Materia es requerido")
    private String materia;

    @NotNull(message = "El campo Curso es requerido")
    private Integer curso;

    @NotNull(message = "El campo Semestre es requerido")
    private Integer semestre;
    
    @NotNull(message = "El campo carrera es requerido")
    @ManyToOne
    @JoinColumn(name = "convenio_carreraprograma_id")
    private ConvenioCarreraPrograma convenioCarrera;

    private String estado;

    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSS")
    private Date fechaRevision;

    private String usuarioRevisor;

    //@NotNull(message = "El Listado de Alumnos con sus datos de prácticas son requeridos")
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "practica_id")
    private List<PracticaDetalle> practicaDetalleList;
    
    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public Convenio getConvenio() {
        return convenio;
    }

    public void setConvenio(Convenio convenio) {
        this.convenio = convenio;
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

    public List<PracticaDetalle> getPracticaDetalleList() {
        return practicaDetalleList;
    }

    public void setPracticaDetalleList(List<PracticaDetalle> practicaDetalleList) {
        this.practicaDetalleList = practicaDetalleList;
    }
	public ConvenioCarreraPrograma getConvenioCarrera() {
		return convenioCarrera;
	}
	public void setConvenioCarrera(ConvenioCarreraPrograma convenioCarrera) {
		this.convenioCarrera = convenioCarrera;
	}

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaRevision() {
        return fechaRevision;
    }

    public void setFechaRevision(Date fechaRevision) {
        this.fechaRevision = fechaRevision;
    }

    public String getUsuarioRevisor() {
        return usuarioRevisor;
    }

    public void setUsuarioRevisor(String usuarioRevisor) {
        this.usuarioRevisor = usuarioRevisor;
    }

}
