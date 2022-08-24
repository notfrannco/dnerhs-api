package py.gov.mspbs.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "servicios")
public class Servicios implements Serializable {

    private static final long serialVersionUID = 90794130676102287L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull(message = "El campo Institución Establecimiento es requerido")
    @OneToOne
    @JoinColumn(name = "instituciones_establecimientos_id")
    private InstitucionEstablecimiento institucionEstablecimiento;

    @NotNull(message = "El Campo Internados por Año es requerido")
    private Boolean internadosAnio;

    private Integer internadosAnioCantidad;

    @NotNull(message = "El Campo Giros Cama es requerido")
    private Boolean girosCama;

    private Integer girosCamaCantidad;

    @NotNull(message = "El Campo Nacimientos por Año es requerido")
    private Boolean nacimientosAnio;

    private Integer nacimientosAnioCantidad;

    @NotNull(message = "El Campo Cirugías Mayores por Año es requerido")
    private Boolean cirugiasMayoresAnio;

    private Integer cirugiasMayoresAnioCantidad;

    @NotNull(message = "El Campo Especialidad Pediatría es requerido")
    private Boolean especialidadPediatria;

    private Integer especialidadPediatriaCantidad;

    @NotNull(message = "El Campo Especialidad Clínica Médica es requerido")
    private Boolean especialidadClinica;

    private Integer especialidadClinicaCantidad;

    @NotNull(message = "El Campo Especialidad Cirugía es requerido")
    private Boolean especialidadCirugia;
    
    @NotNull(message = "El Campo Especialidad Cirugía Cantidad es requerido")
    private Integer especialidadCirugiaCantidad;

    @NotNull(message = "El Campo Especialidad Ginecobstetricia es requerido")
    private Boolean especialidadGinecobstetricia;

    private Integer especialidadGinecobstetriciaCantidad;

    @NotNull(message = "El Campo Especialidad Medicina Familiar es requerido")
    private Boolean especialidadMedicinaFamiliar;

    private Integer especialidadMedicinaFamiliarCantidad;

    @NotNull(message = "El Campo Auxiliares de Laboratorio es requerido")
    private Boolean auxiliaresLaboratorio;

    private Integer auxiliaresLaboratorioCantidad;

    @NotNull(message = "El Campo Auxilires de Imágenes es requerido")
    private Boolean auxiliaresImagenes;

    private Integer auxiliaresImagenesCantidad;

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

    public Boolean getInternadosAnio() {
        return internadosAnio;
    }

    public void setInternadosAnio(Boolean internadosAnio) {
        this.internadosAnio = internadosAnio;
    }

    public Boolean getGirosCama() {
        return girosCama;
    }

    public void setGirosCama(Boolean girosCama) {
        this.girosCama = girosCama;
    }

    public Boolean getNacimientosAnio() {
        return nacimientosAnio;
    }

    public void setNacimientosAnio(Boolean nacimientosAnio) {
        this.nacimientosAnio = nacimientosAnio;
    }

    public Boolean getCirugiasMayoresAnio() {
        return cirugiasMayoresAnio;
    }

    public void setCirugiasMayoresAnio(Boolean cirugiasMayoresAnio) {
        this.cirugiasMayoresAnio = cirugiasMayoresAnio;
    }

    public Boolean getEspecialidadPediatria() {
        return especialidadPediatria;
    }

    public void setEspecialidadPediatria(Boolean especialidadPediatria) {
        this.especialidadPediatria = especialidadPediatria;
    }

    public Boolean getEspecialidadClinica() {
        return especialidadClinica;
    }

    public void setEspecialidadClinica(Boolean especialidadClinica) {
        this.especialidadClinica = especialidadClinica;
    }

    public Boolean getEspecialidadCirugia() {
        return especialidadCirugia;
    }

    public void setEspecialidadCirugia(Boolean especialidadCirugia) {
        this.especialidadCirugia = especialidadCirugia;
    }

    public Integer getEspecialidadCirugiaCantidad() {
		return especialidadCirugiaCantidad;
	}

	public void setEspecialidadCirugiaCantidad(Integer especialidadCirugiaCantidad) {
		this.especialidadCirugiaCantidad = especialidadCirugiaCantidad;
	}

	public Boolean getEspecialidadGinecobstetricia() {
        return especialidadGinecobstetricia;
    }

    public void setEspecialidadGinecobstetricia(Boolean especialidadGinecobstetricia) {
        this.especialidadGinecobstetricia = especialidadGinecobstetricia;
    }

    public Boolean getEspecialidadMedicinaFamiliar() {
        return especialidadMedicinaFamiliar;
    }

    public void setEspecialidadMedicinaFamiliar(Boolean especialidadMedicinaFamiliar) {
        this.especialidadMedicinaFamiliar = especialidadMedicinaFamiliar;
    }

    public Boolean getAuxiliaresLaboratorio() {
        return auxiliaresLaboratorio;
    }

    public void setAuxiliaresLaboratorio(Boolean auxiliaresLaboratorio) {
        this.auxiliaresLaboratorio = auxiliaresLaboratorio;
    }

    public Boolean getAuxiliaresImagenes() {
        return auxiliaresImagenes;
    }

    public void setAuxiliaresImagenes(Boolean auxiliaresImagenes) {
        this.auxiliaresImagenes = auxiliaresImagenes;
    }

    public Integer getInternadosAnioCantidad() {
        return internadosAnioCantidad;
    }

    public void setInternadosAnioCantidad(Integer internadosAnioCantidad) {
        this.internadosAnioCantidad = internadosAnioCantidad;
    }

    public Integer getGirosCamaCantidad() {
        return girosCamaCantidad;
    }

    public void setGirosCamaCantidad(Integer girosCamaCantidad) {
        this.girosCamaCantidad = girosCamaCantidad;
    }

    public Integer getNacimientosAnioCantidad() {
        return nacimientosAnioCantidad;
    }

    public void setNacimientosAnioCantidad(Integer nacimientosAnioCantidad) {
        this.nacimientosAnioCantidad = nacimientosAnioCantidad;
    }

    public Integer getCirugiasMayoresAnioCantidad() {
        return cirugiasMayoresAnioCantidad;
    }

    public void setCirugiasMayoresAnioCantidad(Integer cirugiasMayoresAnioCantidad) {
        this.cirugiasMayoresAnioCantidad = cirugiasMayoresAnioCantidad;
    }

    public Integer getEspecialidadPediatriaCantidad() {
        return especialidadPediatriaCantidad;
    }

    public void setEspecialidadPediatriaCantidad(Integer especialidadPediatriaCantidad) {
        this.especialidadPediatriaCantidad = especialidadPediatriaCantidad;
    }

    public Integer getEspecialidadClinicaCantidad() {
        return especialidadClinicaCantidad;
    }

    public void setEspecialidadClinicaCantidad(Integer especialidadClinicaCantidad) {
        this.especialidadClinicaCantidad = especialidadClinicaCantidad;
    }

    public Integer getEspecialidadGinecobstetriciaCantidad() {
        return especialidadGinecobstetriciaCantidad;
    }

    public void setEspecialidadGinecobstetriciaCantidad(Integer especialidadGinecobstetriciaCantidad) {
        this.especialidadGinecobstetriciaCantidad = especialidadGinecobstetriciaCantidad;
    }

    public Integer getEspecialidadMedicinaFamiliarCantidad() {
        return especialidadMedicinaFamiliarCantidad;
    }

    public void setEspecialidadMedicinaFamiliarCantidad(Integer especialidadMedicinaFamiliarCantidad) {
        this.especialidadMedicinaFamiliarCantidad = especialidadMedicinaFamiliarCantidad;
    }

    public Integer getAuxiliaresLaboratorioCantidad() {
        return auxiliaresLaboratorioCantidad;
    }

    public void setAuxiliaresLaboratorioCantidad(Integer auxiliaresLaboratorioCantidad) {
        this.auxiliaresLaboratorioCantidad = auxiliaresLaboratorioCantidad;
    }

    public Integer getAuxiliaresImagenesCantidad() {
        return auxiliaresImagenesCantidad;
    }

    public void setAuxiliaresImagenesCantidad(Integer auxiliaresImagenesCantidad) {
        this.auxiliaresImagenesCantidad = auxiliaresImagenesCantidad;
    }
}
