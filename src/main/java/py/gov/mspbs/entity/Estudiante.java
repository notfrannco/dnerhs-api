/**
 * 
 */
package py.gov.mspbs.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "estudiante")
public class Estudiante extends AuditBaseEntity implements Serializable {

	private static final long serialVersionUID = 7571588740521624386L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "El campo Cédula de identidad es un campo requerido")
	private Integer cedulaIdentidad;

	@NotNull(message = "El campo Nombres es un campo requerido")
	private String nombres;

	@NotNull(message = "El campo Apellidos es un campo requerido")
	private String apellidos;

	@NotNull(message = "El campo Fecha de Nacimiento es un campo requerido")
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSS")
	private Date fechaNacimiento;

	@ManyToOne
	@JoinColumn(name = "nacionalidad_id")
	@NotNull(message = "El campo Nacionalidad es un campo requerido")
	private Nacionalidad nacionalidad;

	@ManyToOne
	@JoinColumn(name = "genero_id")
	@NotNull(message = "El campo Sexo es un campo requerido")
	private Genero sexo;

	@ManyToOne
	@JoinColumn(name = "carreraprograma_id")
	@NotNull(message = "El campo Carrera es un campo requerido")
	private CarreraPrograma carrera;

	@NotNull(message = "El campo Curso es un campo requerido")
	private Integer curso;

	@NotNull(message = "El campo Semestre es un campo requerido")
	private Integer semestre;

	@NotNull(message = "El campo Año es un campo requerido")
	private Integer anio;

	@NotNull(message = "El campo Materia es un campo requerido")
	private String materia;

	@NotNull(message = "El documento de bioseguridad es requerido")
	private String bioseguridad;

	@NotNull(message = "El contrato es un documento requerido")
	private String contrato;

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

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Nacionalidad getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(Nacionalidad nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public Genero getSexo() {
		return sexo;
	}

	public void setSexo(Genero sexo) {
		this.sexo = sexo;
	}

	public CarreraPrograma getCarrera() {
		return carrera;
	}

	public void setCarrera(CarreraPrograma carrera) {
		this.carrera = carrera;
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

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	public String getBioseguridad() {
		return bioseguridad;
	}

	public void setBioseguridad(String bioseguridad) {
		this.bioseguridad = bioseguridad;
	}

	public String getContrato() {
		return contrato;
	}

	public void setContrato(String contrato) {
		this.contrato = contrato;
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
		Estudiante other = (Estudiante) obj;
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
		return "Alumno [id=" + id +"]";
	}

}
