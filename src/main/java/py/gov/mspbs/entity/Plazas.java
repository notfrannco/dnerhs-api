package py.gov.mspbs.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "plazas")
public class Plazas implements Serializable {

    private static final long serialVersionUID = 7562562224496408296L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull(message = "El campo Institución Establecimiento es requerido")
    @OneToOne
    @JoinColumn(name = "instituciones_establecimientos_id")
    private InstitucionEstablecimiento institucionEstablecimiento;

    @NotNull(message = "El Campo Medicina. Alumnos Internos es requerido")
    private Boolean medicinaAlumnosInternos;

    private Integer medicinaAlumnosInternosCantidad;

    @NotNull(message = "El Campo Medicina. Alumnos de años inferiores por rotación es requerido")
    private Boolean medicianAlumnosAniosInferiores;

    private Integer medicianAlumnosAniosInferioresCantidad;

    @NotNull(message = "El Campo Enfermería es requerido")
    private Boolean enfermeria;

    private Integer enfermeriaCantidad;

    @NotNull(message = "El Campo Obstetricia es requerido")
    private Boolean obstetricia;

    private Integer obstetriciaCantidad;

    @NotNull(message = "El Campo Odontología es requerido")
    private Boolean odontologia;

    private Integer odontologiaCantidad;

    @NotNull(message = "El Campo Kinesiología es requerido")
    private Boolean kinesiologia;

    private Integer kinesiologiaCantidad;

    @NotNull(message = "El Campo Nutrición es requerido")
    private Boolean nutricion;

    private Integer nutricionCantidad;

    @NotNull(message = "El Campo Psicología es requerido")
    private Boolean psicologia;

    private Integer psicologiaCantidad;

    @NotNull(message = "El Campo Fisioterapia es requerido")
    private Boolean fisioterapia;

    private Integer fisioterapiaCantidad;

    @NotNull(message = "El Campo Radiología es requerido")
    private Boolean radiologia;

    private Integer radiologiaCantidad;

    @NotNull(message = "El Campo Bioguímica es requerido")
    private Boolean bioquimica;

    private Integer bioquimicaCantidad;

    @NotNull(message = "El Campo Farmacia es requerido")
    private Boolean farmacia;

    private Integer farmaciaCantidad;

    @NotNull(message = "El Campo Instrumentación es requerido")
    private Boolean instrumentacion;

    private Integer instrumentacionCantidad;

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

	public Boolean getMedicinaAlumnosInternos() {
        return medicinaAlumnosInternos;
    }

    public void setMedicinaAlumnosInternos(Boolean medicinaAlumnosInternos) {
        this.medicinaAlumnosInternos = medicinaAlumnosInternos;
    }

    public Integer getMedicinaAlumnosInternosCantidad() {
        return medicinaAlumnosInternosCantidad;
    }

    public void setMedicinaAlumnosInternosCantidad(Integer medicinaAlumnosInternosCantidad) {
        this.medicinaAlumnosInternosCantidad = medicinaAlumnosInternosCantidad;
    }

    public Boolean getMedicianAlumnosAniosInferiores() {
        return medicianAlumnosAniosInferiores;
    }

    public void setMedicianAlumnosAniosInferiores(Boolean medicianAlumnosAniosInferiores) {
        this.medicianAlumnosAniosInferiores = medicianAlumnosAniosInferiores;
    }

    public Integer getMedicianAlumnosAniosInferioresCantidad() {
        return medicianAlumnosAniosInferioresCantidad;
    }

    public void setMedicianAlumnosAniosInferioresCantidad(Integer medicianAlumnosAniosInferioresCantidad) {
        this.medicianAlumnosAniosInferioresCantidad = medicianAlumnosAniosInferioresCantidad;
    }

    public Boolean getEnfermeria() {
        return enfermeria;
    }

    public void setEnfermeria(Boolean enfermeria) {
        this.enfermeria = enfermeria;
    }

    public Integer getEnfermeriaCantidad() {
        return enfermeriaCantidad;
    }

    public void setEnfermeriaCantidad(Integer enfermeriaCantidad) {
        this.enfermeriaCantidad = enfermeriaCantidad;
    }

    public Boolean getObstetricia() {
        return obstetricia;
    }

    public void setObstetricia(Boolean obstetricia) {
        this.obstetricia = obstetricia;
    }

    public Integer getObstetriciaCantidad() {
        return obstetriciaCantidad;
    }

    public void setObstetriciaCantidad(Integer obstetriciaCantidad) {
        this.obstetriciaCantidad = obstetriciaCantidad;
    }

    public Boolean getOdontologia() {
        return odontologia;
    }

    public void setOdontologia(Boolean odontologia) {
        this.odontologia = odontologia;
    }

    public Integer getOdontologiaCantidad() {
        return odontologiaCantidad;
    }

    public void setOdontologiaCantidad(Integer odontologiaCantidad) {
        this.odontologiaCantidad = odontologiaCantidad;
    }

    public Boolean getKinesiologia() {
        return kinesiologia;
    }

    public void setKinesiologia(Boolean kinesiologia) {
        this.kinesiologia = kinesiologia;
    }

    public Integer getKinesiologiaCantidad() {
        return kinesiologiaCantidad;
    }

    public void setKinesiologiaCantidad(Integer kinesiologiaCantidad) {
        this.kinesiologiaCantidad = kinesiologiaCantidad;
    }

    public Boolean getNutricion() {
        return nutricion;
    }

    public void setNutricion(Boolean nutricion) {
        this.nutricion = nutricion;
    }

    public Integer getNutricionCantidad() {
        return nutricionCantidad;
    }

    public void setNutricionCantidad(Integer nutricionCantidad) {
        this.nutricionCantidad = nutricionCantidad;
    }

    public Boolean getPsicologia() {
        return psicologia;
    }

    public void setPsicologia(Boolean psicologia) {
        this.psicologia = psicologia;
    }

    public Integer getPsicologiaCantidad() {
        return psicologiaCantidad;
    }

    public void setPsicologiaCantidad(Integer psicologiaCantidad) {
        this.psicologiaCantidad = psicologiaCantidad;
    }

    public Boolean getFisioterapia() {
        return fisioterapia;
    }

    public void setFisioterapia(Boolean fisioterapia) {
        this.fisioterapia = fisioterapia;
    }

    public Integer getFisioterapiaCantidad() {
        return fisioterapiaCantidad;
    }

    public void setFisioterapiaCantidad(Integer fisioterapiaCantidad) {
        this.fisioterapiaCantidad = fisioterapiaCantidad;
    }

    public Boolean getRadiologia() {
        return radiologia;
    }

    public void setRadiologia(Boolean radiologia) {
        this.radiologia = radiologia;
    }

    public Integer getRadiologiaCantidad() {
        return radiologiaCantidad;
    }

    public void setRadiologiaCantidad(Integer radiologiaCantidad) {
        this.radiologiaCantidad = radiologiaCantidad;
    }

    public Boolean getBioquimica() {
        return bioquimica;
    }

    public void setBioquimica(Boolean bioquimica) {
        this.bioquimica = bioquimica;
    }

    public Integer getBioquimicaCantidad() {
        return bioquimicaCantidad;
    }

    public void setBioquimicaCantidad(Integer bioquimicaCantidad) {
        this.bioquimicaCantidad = bioquimicaCantidad;
    }

    public Boolean getFarmacia() {
        return farmacia;
    }

    public void setFarmacia(Boolean farmacia) {
        this.farmacia = farmacia;
    }

    public Integer getFarmaciaCantidad() {
        return farmaciaCantidad;
    }

    public void setFarmaciaCantidad(Integer farmaciaCantidad) {
        this.farmaciaCantidad = farmaciaCantidad;
    }

    public Boolean getInstrumentacion() {
        return instrumentacion;
    }

    public void setInstrumentacion(Boolean instrumentacion) {
        this.instrumentacion = instrumentacion;
    }

    public Integer getInstrumentacionCantidad() {
        return instrumentacionCantidad;
    }

    public void setInstrumentacionCantidad(Integer instrumentacionCantidad) {
        this.instrumentacionCantidad = instrumentacionCantidad;
    }
}
