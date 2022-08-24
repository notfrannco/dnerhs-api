/**
 * 
 */
package py.gov.mspbs.entity;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "instituciones_establecimientos")
public class InstitucionEstablecimiento extends AuditBaseEntity implements Serializable {

	private static final long serialVersionUID = -5861171753450367910L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "El campo nombre servicio es un campo requerido.")
	@ManyToOne
	@JoinColumn(name = "nombres_servicios_id", unique = true, nullable = false)
	private NombreServicio nombreServicio;

	@NotNull(message = "El campo Tipo de Establecimiento es un campo requerido")
	@ManyToOne
	@JoinColumn(name = "tipo_establecimiento_id", nullable = false)
	private TipoEstablecimiento tipoEstablecimiento;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public NombreServicio getNombreServicio() {
		return nombreServicio;
	}

	public void setNombreServicio(NombreServicio nombreServicio) {
		this.nombreServicio = nombreServicio;
	}

	public TipoEstablecimiento getTipoEstablecimiento() {
		return tipoEstablecimiento;
	}

	public void setTipoEstablecimiento(TipoEstablecimiento tipoEstablecimiento) {
		this.tipoEstablecimiento = tipoEstablecimiento;
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
		InstitucionEstablecimiento other = (InstitucionEstablecimiento) obj;
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
		return "InstitucionEstablecimiento [id=" + id + "]";
	}

}
