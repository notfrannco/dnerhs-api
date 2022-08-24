package py.gov.mspbs.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "profesionales_salud")
public class ProfesionalesSalud implements Serializable {

    private static final long serialVersionUID = -1554586029739673347L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull(message = "El campo Institución Establecimiento es un campo requerido")
    @OneToOne
    @JoinColumn(name = "instituciones_establecimientos_id", nullable = false)
    private InstitucionEstablecimiento institucionEstablecimiento;

    @NotNull(message = "El campo Médicos Medicina Clínica es un campo requerido")
    private Boolean medicosMedicinaClinicas;

    private Integer medicosMedicinaClinicasCantidad;
    
    @NotNull(message = "El campo Médicos Pediatras es un campo requerido")
    private Boolean medicosPediatras;

    private Integer medicosPediatrasCantidad;
    
    
    @NotNull(message = "El campo Médicos Cirujanos es un campo requerido")
    private Boolean medicosCirujanos;

    private Integer medicosCirujanosCantidad;
    
    @NotNull(message = "El campo Médicos Ginecobstetra es un campo requerido")
    private Boolean medicosGinecobstetras;

    private Integer medicosGinecobstetrasCantidad;
    
    @NotNull(message = "El campo Médicos Medicina Familiar es un campo requerido")
    private Boolean medicosMedicinaFamiliar;

    private Integer medicosMedicinaFamiliarCantidad;
  
    @NotNull(message = "El campo Licenciados en Enfermería es un campo requerido")
    private Boolean enfermeros;

    private Integer enfermerosCantidad;

    @NotNull(message = "El campo Odontólogos es un campo requerido")
    private Boolean odontologos;

    private Integer odontologosCantidad;

    @NotNull(message = "El campo Bioquímicos es un campo requerido")
    private Boolean bioquimicos;

    private Integer bioquimicosCantidad;

    @NotNull(message = "El campo Licenciados en Kinesiología y Fisioterapia es un campo requerido")
    private Boolean kinesiologos;

    private Integer kinesiologosCantidad;

    @NotNull(message = "El campo Licenciados en Farmacia es un campo requerido")
    private Boolean farmaceuticos;

    private Integer farmaceuticosCantidad;

    @NotNull(message = "El campo Nutricionistas es un campo requerido")
    private Boolean nutricionistas;

    private Integer nutricionistasCantidad;

    @NotNull(message = "El campo Psicólogos es un campo requerido")
    private Boolean psicologos;

    private Integer psicologosCantidad;

    @NotNull(message = "El campo Fonoaudiólogos es un campo requerido")
    private Boolean fonoaudiologos;

    private Integer fonoaudiologosCantidad;

    @NotNull(message = "El campo Instrumentadores Quirúrgicos es un campo requerido")
    private Boolean instrumentadores;

    private Integer instrumentadoresCantidad;

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

    public Boolean getMedicosMedicinaClinicas() {
		return medicosMedicinaClinicas;
	}

	public void setMedicosMedicinaClinicas(Boolean medicosMedicinaClinicas) {
		this.medicosMedicinaClinicas = medicosMedicinaClinicas;
	}

	public Integer getMedicosMedicinaClinicasCantidad() {
		return medicosMedicinaClinicasCantidad;
	}

	public void setMedicosMedicinaClinicasCantidad(Integer medicosMedicinaClinicasCantidad) {
		this.medicosMedicinaClinicasCantidad = medicosMedicinaClinicasCantidad;
	}

	public Boolean getMedicosPediatras() {
		return medicosPediatras;
	}

	public void setMedicosPediatras(Boolean medicosPediatras) {
		this.medicosPediatras = medicosPediatras;
	}

	public Integer getMedicosPediatrasCantidad() {
		return medicosPediatrasCantidad;
	}

	public void setMedicosPediatrasCantidad(Integer medicosPediatrasCantidad) {
		this.medicosPediatrasCantidad = medicosPediatrasCantidad;
	}

	public Boolean getMedicosCirujanos() {
		return medicosCirujanos;
	}

	public void setMedicosCirujanos(Boolean medicosCirujanos) {
		this.medicosCirujanos = medicosCirujanos;
	}

	public Integer getMedicosCirujanosCantidad() {
		return medicosCirujanosCantidad;
	}

	public void setMedicosCirujanosCantidad(Integer medicosCirujanosCantidad) {
		this.medicosCirujanosCantidad = medicosCirujanosCantidad;
	}

	public Boolean getMedicosGinecobstetras() {
		return medicosGinecobstetras;
	}

	public void setMedicosGinecobstetras(Boolean medicosGinecobstetras) {
		this.medicosGinecobstetras = medicosGinecobstetras;
	}

	public Integer getMedicosGinecobstetrasCantidad() {
		return medicosGinecobstetrasCantidad;
	}

	public void setMedicosGinecobstetrasCantidad(Integer medicosGinecobstetrasCantidad) {
		this.medicosGinecobstetrasCantidad = medicosGinecobstetrasCantidad;
	}

	public Boolean getMedicosMedicinaFamiliar() {
		return medicosMedicinaFamiliar;
	}

	public void setMedicosMedicinaFamiliar(Boolean medicosMedicinaFamiliar) {
		this.medicosMedicinaFamiliar = medicosMedicinaFamiliar;
	}

	public Integer getMedicosMedicinaFamiliarCantidad() {
		return medicosMedicinaFamiliarCantidad;
	}

	public void setMedicosMedicinaFamiliarCantidad(Integer medicosMedicinaFamiliarCantidad) {
		this.medicosMedicinaFamiliarCantidad = medicosMedicinaFamiliarCantidad;
	}

	public Boolean getEnfermeros() {
        return enfermeros;
    }

    public void setEnfermeros(Boolean enfermeros) {
        this.enfermeros = enfermeros;
    }

    public Integer getEnfermerosCantidad() {
        return enfermerosCantidad;
    }

    public void setEnfermerosCantidad(Integer enfermerosCantidad) {
        this.enfermerosCantidad = enfermerosCantidad;
    }

    public Boolean getOdontologos() {
        return odontologos;
    }

    public void setOdontologos(Boolean odontologos) {
        this.odontologos = odontologos;
    }

    public Integer getOdontologosCantidad() {
        return odontologosCantidad;
    }

    public void setOdontologosCantidad(Integer odontologosCantidad) {
        this.odontologosCantidad = odontologosCantidad;
    }

    public Boolean getKinesiologos() {
        return kinesiologos;
    }

    public void setKinesiologos(Boolean kinesiologos) {
        this.kinesiologos = kinesiologos;
    }

    public Integer getKinesiologosCantidad() {
        return kinesiologosCantidad;
    }

    public void setKinesiologosCantidad(Integer kinesiologosCantidad) {
        this.kinesiologosCantidad = kinesiologosCantidad;
    }

    public Boolean getFarmaceuticos() {
        return farmaceuticos;
    }

    public void setFarmaceuticos(Boolean farmaceuticos) {
        this.farmaceuticos = farmaceuticos;
    }

    public Integer getFarmaceuticosCantidad() {
        return farmaceuticosCantidad;
    }

    public void setFarmaceuticosCantidad(Integer farmaceuticosCantidad) {
        this.farmaceuticosCantidad = farmaceuticosCantidad;
    }

    public Boolean getNutricionistas() {
        return nutricionistas;
    }

    public void setNutricionistas(Boolean nutricionistas) {
        this.nutricionistas = nutricionistas;
    }

    public Integer getNutricionistasCantidad() {
        return nutricionistasCantidad;
    }

    public void setNutricionistasCantidad(Integer nutricionistasCantidad) {
        this.nutricionistasCantidad = nutricionistasCantidad;
    }

    public Boolean getPsicologos() {
        return psicologos;
    }

    public void setPsicologos(Boolean psicologos) {
        this.psicologos = psicologos;
    }

    public Integer getPsicologosCantidad() {
        return psicologosCantidad;
    }

    public void setPsicologosCantidad(Integer psicologosCantidad) {
        this.psicologosCantidad = psicologosCantidad;
    }

    public Boolean getFonoaudiologos() {
        return fonoaudiologos;
    }

    public void setFonoaudiologos(Boolean fonoaudiologos) {
        this.fonoaudiologos = fonoaudiologos;
    }

    public Integer getFonoaudiologosCantidad() {
        return fonoaudiologosCantidad;
    }

    public void setFonoaudiologosCantidad(Integer fonoaudiologosCantidad) {
        this.fonoaudiologosCantidad = fonoaudiologosCantidad;
    }

    public Boolean getInstrumentadores() {
        return instrumentadores;
    }

    public void setInstrumentadores(Boolean instrumentadores) {
        this.instrumentadores = instrumentadores;
    }

    public Integer getInstrumentadoresCantidad() {
        return instrumentadoresCantidad;
    }

    public void setInstrumentadoresCantidad(Integer instrumentadoresCantidad) {
        this.instrumentadoresCantidad = instrumentadoresCantidad;
    }

    public Boolean getBioquimicos() {
        return bioquimicos;
    }

    public void setBioquimicos(Boolean bioquimicos) {
        this.bioquimicos = bioquimicos;
    }

    public Integer getBioquimicosCantidad() {
        return bioquimicosCantidad;
    }

    public void setBioquimicosCantidad(Integer bioquimicosCantidad) {
        this.bioquimicosCantidad = bioquimicosCantidad;
    }
}
