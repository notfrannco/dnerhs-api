package py.gov.mspbs.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "usuario")
public class Usuario extends AuditBaseEntity implements Serializable {

	private static final long serialVersionUID = -221832901717441627L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonIgnore
	@NotNull(message = "El password es un campo requerido")
	@Column(nullable = false)
	private String password;

	@NotNull(message = "El usuario es un campo requerido")
	@Column(nullable = false, unique = true)
	private String username;

	@ManyToOne
	@JoinColumn(name = "role", nullable = true)
	private Role role;

	@OneToMany
	@JoinColumn(name = "usuario_id")
	private List<InstitucionFormadoraResponsableMaximaAutoridad> institucionFormadoraResponsableMaximaAutoridadList;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}

	public List<InstitucionFormadoraResponsableMaximaAutoridad> getInstitucionFormadoraResponsableMaximaAutoridadList() {
		return institucionFormadoraResponsableMaximaAutoridadList;
	}
	public void setInstitucionFormadoraResponsableMaximaAutoridadList(List<InstitucionFormadoraResponsableMaximaAutoridad> institucionFormadoraResponsableMaximaAutoridadList) {
		this.institucionFormadoraResponsableMaximaAutoridadList = institucionFormadoraResponsableMaximaAutoridadList;
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
		Usuario other = (Usuario) obj;
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
		return "Usuario [id=" + id +"]";
	}

}
