/**
 * 
 */
package py.gov.mspbs.entity;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tutor")
public class Tutor extends AuditBaseEntity implements Serializable {

	private static final long serialVersionUID = 5340730744364573534L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "El campo Cédula de identidad es un campo requerido")
	private Integer cedulaIdentidad;
	
	@NotNull(message = "El campo Nombre es un campo requerido")
	private String nombres;
	
	@NotNull(message = "El campo Apellido es un campo requerido")
	private String apellidos;
	
	@NotNull(message = "El campo Email es un campo requerido")
	@Email(message = "Formato de email inválido.")
	private String email;
	
	@NotNull(message = "El campo Materia es un campo requerido")
	private String materia;
	
	@NotNull(message = "El campo Curso es un campo requerido")
	private String curso;
	
	@NotNull(message = "El campo Nro. Registro Profesional Vigente es un campo requerido")
	private String numeroRegistroProfesionalVigente;
	
	@ManyToOne
	@JoinColumn(name = "carrera_programa_id")
	@NotNull(message = "El campo Carrera es un campo requerido")
	private CarreraPrograma carrera;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getCedulaIdentidad() {
		return cedulaIdentidad;
	}

	public void setCedulaIdentidad(Integer cedulaIdentidad) {
		this.cedulaIdentidad = cedulaIdentidad;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}
	
	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getNumeroRegistroProfesionalVigente() {
		return numeroRegistroProfesionalVigente;
	}

	public void setNumeroRegistroProfesionalVigente(String numeroRegistroProfesionalVigente) {
		this.numeroRegistroProfesionalVigente = numeroRegistroProfesionalVigente;
	}

	public CarreraPrograma getCarrera() {
		return carrera;
	}

	public void setCarrera(CarreraPrograma carrera) {
		this.carrera = carrera;
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

	@Override
	public String toString() {
		return "Tutor [id=" + id +"]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Tutor other = (Tutor) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}
	
}
