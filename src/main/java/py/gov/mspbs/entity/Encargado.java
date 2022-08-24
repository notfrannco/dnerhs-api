package py.gov.mspbs.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "encargado")
public class Encargado implements Serializable {

    private static final long serialVersionUID = 881397261567236029L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull(message = "El campo Institución Establecimiento es un campo requerido")
    @OneToOne
    @JoinColumn(name = "instituciones_establecimientos_id", nullable = false)
    private InstitucionEstablecimiento institucionEstablecimiento;

    @NotNull(message = "El campo cédula de identidad es un campo requerido")
    @Column(nullable = false)
    private Integer cedulaIdentidad;

    @NotNull(message = "El campo nombres es un campo requerido")
    @Column(nullable = false)
    private String nombres;

    @NotNull(message = "El campo apellido es un campo requerido")
    @Column(nullable = false)
    private String Apellidos;

    @NotNull(message = "El campo cargo es un campo requerido")
    @Column(nullable = false)
    private String Cargo;

    @NotNull(message = "El campo teléfono es un campo requerido")
    @Column(nullable = false)
    private String telefono;

    @NotNull(message = "El campo email es un campo requerido")
    @Email(message = "Formato de email inválido.")
    private String email;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public InstitucionEstablecimiento getInstitucionEstablecimiento() {
        return institucionEstablecimiento;
    }

    public void setInstitucionEstablecimiento(InstitucionEstablecimiento institucionEstablecimiento) {
        this.institucionEstablecimiento = institucionEstablecimiento;
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

}
