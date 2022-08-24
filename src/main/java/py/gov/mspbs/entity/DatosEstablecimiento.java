package py.gov.mspbs.entity;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "datos_establecimientos")
public class DatosEstablecimiento implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull(message = "El campo Institución Establecimiento es requerido")
    @OneToOne
    @JoinColumn(name = "instituciones_establecimientos_id")
    private InstitucionEstablecimiento institucionEstablecimiento;

    @Valid
    @NotNull(message = "El campo Region Sanitaria es requerido")
    @ManyToOne
    @JoinColumn(name = "regiones_sanitarias_id", nullable = false)
    private RegionSanitaria regionSanitaria;

    @Valid
    @NotNull(message = "El Campo Nivel de Servicio es requerido")
    @ManyToOne
    @JoinColumn(name = "niveles_servicios_id", nullable = false)
    private NivelServicio nivelServicio;

    @NotNull(message = "El campo Tipo de Habilitación es requerido")
    private String tipoHabilitacion;

    @NotNull(message = "El campo Habilitación es requerido")
    private String habilitacion;

    @NotNull(message = "El campo Tipo de Acreditación es requerido")
    private String tipoAcreditacion;

    @NotNull(message = "El campo Acreditación es requerido")
    private String acreditacion;

    @NotNull(message = "El campo Dirección es requerido")
    private String direccion;

    @NotNull(message = "El campo Correo Electrónico es requerido")
    @Email(message = "Formato de email inválido.")
    private String email;

    @NotNull(message = "El campo Teléfono es requerido")
    private String telefono;

    public RegionSanitaria getRegionSanitaria() {
        return regionSanitaria;
    }

    public void setRegionSanitaria(RegionSanitaria regionSanitaria) {
        this.regionSanitaria = regionSanitaria;
    }

    public NivelServicio getNivelServicio() {
        return nivelServicio;
    }

    public void setNivelServicio(NivelServicio nivelServicio) {
        this.nivelServicio = nivelServicio;
    }

    public String getTipoHabilitacion() {
        return tipoHabilitacion;
    }

    public void setTipoHabilitacion(String tipoHabilitacion) {
        this.tipoHabilitacion = tipoHabilitacion;
    }

    public String getHabilitacion() {
        return habilitacion;
    }

    public void setHabilitacion(String habilitacion) {
        this.habilitacion = habilitacion;
    }

    public String getTipoAcreditacion() {
        return tipoAcreditacion;
    }

    public void setTipoAcreditacion(String tipoAcreditacion) {
        this.tipoAcreditacion = tipoAcreditacion;
    }

    public String getAcreditacion() {
        return acreditacion;
    }

    public void setAcreditacion(String acreditacion) {
        this.acreditacion = acreditacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public InstitucionEstablecimiento getInstitucionEstablecimiento() {
        return institucionEstablecimiento;
    }

    public void setInstitucionEstablecimiento(InstitucionEstablecimiento institucionEstablecimiento) {
        this.institucionEstablecimiento = institucionEstablecimiento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
