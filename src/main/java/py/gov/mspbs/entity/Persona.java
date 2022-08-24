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
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "persona")
public class Persona implements Serializable {

	private static final long serialVersionUID = -5226990476156974497L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "El campo nombre es un campo requerido")
	@Column(nullable = false)
	private String nombre;
	
	@NotNull(message = "El campo apellido es un campo requerido")
	@Column(nullable = false)
	private String apellido;
	
	@NotNull(message = "El campo cedula de identidad es un campo requerido")
	@Column(nullable = false)
	private Integer cedulaIdentidad;
	
	private String telefono;
	
	@NotNull(message = "El campo email es un campo requerido")
	@Email(message = "Formato de email inválido.")
	@Column(nullable = false)
	private String email;
	
	@NotNull(message = "El campo genero es un campo requerido")
	@ManyToOne
	@JoinColumn(name = "genero_id", nullable = false)
	private Genero genero;

	@ManyToOne
	@JoinColumn(name = "nacionalidad_id")
	private Nacionalidad nacionalidad;
	
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
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

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public Nacionalidad getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(Nacionalidad nacionalidad) {
		this.nacionalidad = nacionalidad;
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
		Persona other = (Persona) obj;
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
		return "Persona [id=" + id +"]";
	}

}
