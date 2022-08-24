package py.gov.mspbs.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "convenio")
public class Convenio extends AuditBaseEntity implements Serializable {

    private static final long serialVersionUID = -4252086255703702500L;

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
    @JoinColumn(name = "institucion_formadora_id")
    private InstitucionFormadora institucionFormadora;

    private String categoria;

    private String estado;

    private String observacion;

    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSS")
    private Date fechaRevision;

    private String usuarioRevisor;

    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSS")
    private Date fechaFirma;

    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSS")
    private Date fechaInicioVigencia;

    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSS")
    private Date fechaFinVigencia;

    public InstitucionFormadora getInstitucionFormadora() {
        return institucionFormadora;
    }

    public void setInstitucionFormadora(InstitucionFormadora institucionFormadora) {
        this.institucionFormadora = institucionFormadora;
    }

    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getObservacion() {
        return observacion;
    }
    public void setObservacion(String observacion) {
        this.observacion = observacion;
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

    public Date getFechaFirma() {
        return fechaFirma;
    }
    public void setFechaFirma(Date fechaFirma) {
        this.fechaFirma = fechaFirma;
    }

    public Date getFechaInicioVigencia() {
        return fechaInicioVigencia;
    }
    public void setFechaInicioVigencia(Date fechaInicioVigencia) {
        this.fechaInicioVigencia = fechaInicioVigencia;
    }

    public Date getFechaFinVigencia() {
        return fechaFinVigencia;
    }
    public void setFechaFinVigencia(Date fechaFinVigencia) {
        this.fechaFinVigencia = fechaFinVigencia;
    }

}
