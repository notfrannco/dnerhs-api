package py.gov.mspbs.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "maxima_autoridad")
public class MaximaAutoridad extends AuditBaseEntity implements Serializable {

    private static final long serialVersionUID = -2272193166751427764L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @NotNull(message = "El campo nombre es un campo requerido")
    @Column(nullable = false)
    private String nombres;

    @NotNull(message = "El campo apellido es un campo requerido")
    @Column(nullable = false)
    private String apellidos;

    @NotNull(message = "El campo cedula de identidad es un campo requerido")
    @Column(nullable = false)
    private Integer cedulaIdentidad;

    private String telefono;

    @NotNull(message = "El campo email es un campo requerido")
    @Email(message = "Formato de email inválido.")
    @Column(nullable = false)
    private String email;

    private String cargo;

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

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
