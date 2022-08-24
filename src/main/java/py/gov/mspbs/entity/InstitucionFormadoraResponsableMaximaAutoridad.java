/**
 * 
 */
package py.gov.mspbs.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "institucion_formadora_responsable_maxima_autoridad")
public class InstitucionFormadoraResponsableMaximaAutoridad extends AuditBaseEntity implements Serializable {

	private static final long serialVersionUID = -2311933522789435667L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "institucion_formadora_id", nullable = false)
	private InstitucionFormadora formadora;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "responsable_id", nullable = false)
	private Responsable responsable;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "maxima_autoridad_id", nullable = false)
	private MaximaAutoridad maximaAutoridad;

	private String estado;

	private String observacion;

	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSS")
	private Date fechaRevision;

	private String usuarioRevisor;


	private String designacionResponsable;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public InstitucionFormadora getFormadora() {
		return formadora;
	}
	public void setFormadora(InstitucionFormadora formadora) {
		this.formadora = formadora;
	}

	public Responsable getResponsable() {
		return responsable;
	}
	public void setResponsable(Responsable responsable) {
		this.responsable = responsable;
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

	public MaximaAutoridad getMaximaAutoridad() {
		return maximaAutoridad;
	}
	public void setMaximaAutoridad(MaximaAutoridad maximaAutoridad) {
		this.maximaAutoridad = maximaAutoridad;
	}

	public String getDesignacionResponsable() {
		return designacionResponsable;
	}
	public void setDesignacionResponsable(String designacionResponsable) {
		this.designacionResponsable = designacionResponsable;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InstitucionFormadoraResponsableMaximaAutoridad other = (InstitucionFormadoraResponsableMaximaAutoridad) obj;
		if (getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!getId().equals(other.getId())) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "InstitucionFormadoraEncargado [id=" + id +"]";
	}

}
