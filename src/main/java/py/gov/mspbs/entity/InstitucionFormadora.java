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
@Table(name = "institucion_formadora")
public class InstitucionFormadora extends AuditBaseEntity implements Serializable {

	private static final long serialVersionUID = -4019307545010324348L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "El campo institución es un campo requerido")
	private String institucion;

	@ManyToOne
	@NotNull(message = "El campo ciudad es un campo requerido")
	@JoinColumn(name = "ciudad_id", nullable = false)
	private Ciudad ciudad;

	@ManyToOne
	@NotNull(message = "El campo departamento es un campo requerido")
	@JoinColumn(name = "departamento_id", nullable = false)
	private Departamento departamento;

	private String direccion;
	
	private String telefono;
	
	private String email;
	
	private Integer ley;

	private String copiaLey;
	
	private String logotipo;

	private String sede;

	@Column(columnDefinition = "integer default 0")
	private Integer asignadas;
	@Column(columnDefinition = "integer default 0")
  private Integer ocupadas;
	@Column(columnDefinition = "integer default 0")
  private Integer disponibles;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getInstitucion() {
		return institucion;
	}
	public void setInstitucion(String institucion) {
		this.institucion = institucion;
	}

	public Ciudad getCiudad() {
		return ciudad;
	}
	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Integer getLey() {
		return ley;
	}
	public void setLey(Integer ley) {
		this.ley = ley;
	}

	public Departamento getDepartamento() {
		return departamento;
	}
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public String getCopiaLey() {
		return copiaLey;
	}
	public void setCopiaLey(String copiaLey) {
		this.copiaLey = copiaLey;
	}

	public String getSede() {
		return sede;
	}
	public void setSede(String sede) {
		this.sede = sede;
	}
	
	public String getLogotipo() {
		return logotipo;
	}
	public void setLogotipo(String logotipo) {
		this.logotipo = logotipo;
	}

	public Integer getAsignadas() {
		return asignadas;
	}
	public void setAsignadas(Integer asignadas) {
		this.asignadas = asignadas;
	}
	public Integer getOcupadas() {
		return ocupadas;
	}
	public void setOcupadas(Integer ocupadas) {
		this.ocupadas = ocupadas;
	}
	public Integer getDisponibles() {
		return disponibles;
	}
	public void setDisponibles(Integer disponibles) {
		this.disponibles = disponibles;
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
		InstitucionFormadora other = (InstitucionFormadora) obj;
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
		return "InstitucionFormadora [id=" + id +"]";
	}

}
