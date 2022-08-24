/**
 * 
 */
package py.gov.mspbs.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "institucion")
public class Institucion extends AuditBaseEntity implements Serializable {

	private static final long serialVersionUID = -157571065755031038L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "El campo nombre es un campo requerido")
	@Column(nullable = false)
	private String nombre;

	@NotNull(message = "El campo acronimo es un campo requerido")
	@Column(nullable = false)
	private String acronimo;

	@NotNull(message = "El campo tipo institución es un campo requerido")
	@ManyToOne
	@JoinColumn(name = "tipo_institucion_id", nullable = false)
	private TipoInstitucion tipoInstitucion;

	private String logoInstitucion;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAcronimo() {
		return acronimo;
	}
	public void setAcronimo(String acronimo) {
		this.acronimo = acronimo;
	}
	
	public TipoInstitucion getTipoInstitucion() {
		return tipoInstitucion;
	}
	public void setTipoInstitucion(TipoInstitucion tipoInstitucion) {
		this.tipoInstitucion = tipoInstitucion;
	}

	public String getLogoInstitucion() {
		return logoInstitucion;
	}
	public void setLogoInstitucion(String logoInstitucion) {
		this.logoInstitucion = logoInstitucion;
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
		Institucion other = (Institucion) obj;
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
		return "Institucion [id=" + id +"]";
	}

}
