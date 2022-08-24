/**
 * 
 */
package py.gov.mspbs.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "responsable")
public class Responsable extends AuditBaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "El campo nombres es un campo requerido")
	@Column(nullable = false)
	private String nombres;

	@NotNull(message = "El campo apellidos es un campo requerido")
	@Column(nullable = false)
	private String apellidos;

	@NotNull(message = "El campo cédula de identidad es un campo requerido")
	@Column(nullable = false)
	private Integer cedulaIdentidad;

	private String telefono;

	@NotNull(message = "El campo email es un campo requerido")
	@Email(message = "Formato de email inválido.")
	@Column(nullable = false)
	private String email;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Integer getCedulaIdentidad() {
		return cedulaIdentidad;
	}

	public void setCedulaIdentidad(Integer cedulaIdentidad) {
		this.cedulaIdentidad = cedulaIdentidad;
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
		Responsable other = (Responsable) obj;
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
		return "Encargado [id=" + id +"]";
	}

}
