/**
 * 
 */
package py.gov.mspbs.entity;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "docente")
public class Docente extends AuditBaseEntity implements Serializable {

	private static final long serialVersionUID = -7872557734930099206L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "El campo persona es un campo requerido")
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "persona_id", nullable = false)
	private Persona persona;

	private String materia;

	private String Semestre;

	private Boolean tituloUniversitario;

	private Boolean didacticaUniversitaria;

	private String registroProfesional;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	public String getSemestre() {
		return Semestre;
	}

	public void setSemestre(String semestre) {
		Semestre = semestre;
	}

	public Boolean getTituloUniversitario() {
		return tituloUniversitario;
	}

	public void setTituloUniversitario(Boolean tituloUniversitario) {
		this.tituloUniversitario = tituloUniversitario;
	}

	public Boolean getDidacticaUniversitaria() {
		return didacticaUniversitaria;
	}

	public void setDidacticaUniversitaria(Boolean didacticaUniversitaria) {
		this.didacticaUniversitaria = didacticaUniversitaria;
	}

	public String getRegistroProfesional() {
		return registroProfesional;
	}

	public void setRegistroProfesional(String registroProfesional) {
		this.registroProfesional = registroProfesional;
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
		Docente other = (Docente) obj;
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
		return "Docente [id=" + id +"]";
	}

}
