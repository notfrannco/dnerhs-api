package py.gov.mspbs.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "responsable_establecimiento")
public class ResponsableEstablecimiento extends AuditBaseEntity implements Serializable {

    private static final long serialVersionUID = 4765610723749482803L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull(message = "El campo Institución Establecimiento es un campo requerido")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "instituciones_establecimientos_id", nullable = false)
    private InstitucionEstablecimiento institucionEstablecimiento;

    @NotNull(message = "El campo cédula de identidad es un campo requerido")
    private Integer cedulaIdentidad;

    @NotNull(message = "El campo nombres es un campo requerido")
    private String nombres;

    @NotNull(message = "El campo apellido es un campo requerido")
    private String Apellidos;

    @NotNull(message = "El campo cargo es un campo requerido")
    private String Cargo;

    @NotNull(message = "El campo teléfono es un campo requerido")
    private String telefono;

    @Column(nullable = false)
    @Email(message = "Formato de email inválido.")
    private String email;

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
        return Apellidos;
    }

    public void setApellidos(String apellidos) {
        Apellidos = apellidos;
    }

    public String getCargo() {
        return Cargo;
    }

    public void setCargo(String cargo) {
        Cargo = cargo;
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

    public InstitucionEstablecimiento getInstitucionEstablecimiento() {
        return institucionEstablecimiento;
    }

    public void setInstitucionEstablecimiento(InstitucionEstablecimiento institucionEstablecimiento) {
        this.institucionEstablecimiento = institucionEstablecimiento;
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
		ResponsableEstablecimiento other = (ResponsableEstablecimiento) obj;
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
		return "ResponsableEstablecimiento [id=" + id + "]";
	}

}