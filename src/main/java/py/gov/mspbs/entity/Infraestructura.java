package py.gov.mspbs.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "infraestructura")
public class Infraestructura implements Serializable {

    private static final long serialVersionUID = 777402394480166635L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull(message = "El campo Institución Establecimiento es un campo requerido")
    @OneToOne
    @JoinColumn(name = "instituciones_establecimientos_id", nullable = false)
    private InstitucionEstablecimiento institucionEstablecimiento;

    @NotNull(message = "El campo camas clinica médica es un campo requerido")
    private Boolean camasClinicaMedica;

    private Integer camasClinicaMedicaCantidad;
    
    @NotNull(message = "El campo camas de pediatria es un campo requerido")
    private Boolean camasPediatria;

    private Integer camasPediatriaCantidad;
    
    @NotNull(message = "El campo camas de cirugia es un campo requerido")
    private Boolean camasCirugia;

    private Integer camasCirugiaCantidad;
    
    @NotNull(message = "El campo camas de ginecologia y obstetricia es un campo requerido")
    private Boolean camasGiniecoObstetricia;

    private Integer camasGiniecoObstetriciaCantidad;
    
    @NotNull(message = "El campo camas de urgencia es un campo requerido")
    private Boolean camasUrgencia;

    private Integer camasUrgenciaCantidad;
    
    @NotNull(message = "El campo camas de UTI es un campo requerido")
    private Boolean camasUnidadTerapiaIntensiva;

    private Integer camasUnidadTerapiaIntensivaCantidad;

    @NotNull(message = "El campo Consultorios Clínica Médica es un campo requerido")
    private Boolean consultorioClinicaMedica;

    private Integer consultorioClinicaMedicaCantidad;
    
    @NotNull(message = "El campo Consultorios Pediatría es un campo requerido")
    private Boolean consultorioPediatria;

    private Integer consultorioPediatriaCantidad;
    
    @NotNull(message = "El campo Consultorios Cirugía es un campo requerido")
    private Boolean consultorioCirugia;

    private Integer consultorioCirugiaCantidad;
    
    @NotNull(message = "El campo Consultorios Ginecología y Obstetricia es un campo requerido")
    private Boolean consultorioGinecoObstetricia;

    private Integer consultorioGinecoObstetriciaCantidad;
  
    @NotNull(message = "El campo Laboratorios es un campo requerido")
    private Boolean laboratorios;

    private Integer laboratoriosCantidad;

    @NotNull(message = "El campo Consultorios Odontológicos es un campo requerido")
    private Boolean consultorioOdontologicos;

    private Integer consultorioOdontologicosCantidad;

    @NotNull(message = "El campo Salas RX - Mamografía es un campo requerido")
    private Boolean salasRxMamografia;

    private Integer salasRxMamografiaCantidad;

    @NotNull(message = "El campo Consultorios para Psicología es un campo requerido")
    private Boolean consultorioPsicologia;

    private Integer consultorioPsicologiaCantidad;

    @NotNull(message = "El campo Consultorios para Nutrición es un campo requerido")
    private Boolean consultorioNutricion;

    private Integer consultorioNutricionCantidad;

    @NotNull(message = "El campo Consultorios para Fisioterapia es un campo requerido")
    private Boolean consultorioFisioterapia;

    private Integer consultorioFisioterapiaCantidad;

    @NotNull(message = "El campo Consultorios para Kinesiología es un campo requerido")
    private Boolean consultorioKinesiologia;

    private Integer consultorioKinesiologiaCantidad;

    @NotNull(message = "El campo Farmacias es un campo requerido")
    private Boolean farmacias;

    private Integer farmaciasCantidad;

    @NotNull(message = "El campo Quirófano es un campo requerido")
    private Boolean quirofanos;

    private Integer quirofanosCantidad;

    @NotNull(message = "El campo Salas de Parto es un campo requerido")
    private Boolean salasParto;

    private Integer salasPartoCantidad;

    @NotNull(message = "El campo Aulas es un campo requerido")
    private Boolean aulas;

    private Integer aulasCantidad;

    @NotNull(message = "El campo Bibliotetecas es un campo requerido")
    private Boolean bibliotecas;

    private Integer bibliotecasCantidad;

    @NotNull(message = "El campo Áreas de Descanso es un campo requerido")
    private boolean areasDescanso;

    private Integer areasDescansoCantidad;

    @NotNull(message = "El campo Vestidores es un campo requerido")
    private Boolean vestidores;

    private Integer vestidoresCantidad;

    @NotNull(message = "El campo Comedores es un campo requerido")
    private Boolean comedores;

    private Integer comedoresCantidad;

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

	public Boolean getCamasClinicaMedica() {
		return camasClinicaMedica;
	}

	public void setCamasClinicaMedica(Boolean camasClinicaMedica) {
		this.camasClinicaMedica = camasClinicaMedica;
	}

	public Integer getCamasClinicaMedicaCantidad() {
		return camasClinicaMedicaCantidad;
	}

	public void setCamasClinicaMedicaCantidad(Integer camasClinicaMedicaCantidad) {
		this.camasClinicaMedicaCantidad = camasClinicaMedicaCantidad;
	}

	public Boolean getCamasPediatria() {
		return camasPediatria;
	}

	public void setCamasPediatria(Boolean camasPediatria) {
		this.camasPediatria = camasPediatria;
	}

	public Integer getCamasPediatriaCantidad() {
		return camasPediatriaCantidad;
	}

	public void setCamasPediatriaCantidad(Integer camasPediatriaCantidad) {
		this.camasPediatriaCantidad = camasPediatriaCantidad;
	}

	public Boolean getCamasCirugia() {
		return camasCirugia;
	}

	public void setCamasCirugia(Boolean camasCirugia) {
		this.camasCirugia = camasCirugia;
	}

	public Integer getCamasCirugiaCantidad() {
		return camasCirugiaCantidad;
	}

	public void setCamasCirugiaCantidad(Integer camasCirugiaCantidad) {
		this.camasCirugiaCantidad = camasCirugiaCantidad;
	}

	public Boolean getCamasGiniecoObstetricia() {
		return camasGiniecoObstetricia;
	}

	public void setCamasGiniecoObstetricia(Boolean camasGiniecoObstetricia) {
		this.camasGiniecoObstetricia = camasGiniecoObstetricia;
	}

	public Integer getCamasGiniecoObstetriciaCantidad() {
		return camasGiniecoObstetriciaCantidad;
	}

	public void setCamasGiniecoObstetriciaCantidad(Integer camasGiniecoObstetriciaCantidad) {
		this.camasGiniecoObstetriciaCantidad = camasGiniecoObstetriciaCantidad;
	}

	public Boolean getCamasUrgencia() {
		return camasUrgencia;
	}

	public void setCamasUrgencia(Boolean camasUrgencia) {
		this.camasUrgencia = camasUrgencia;
	}

	public Integer getCamasUrgenciaCantidad() {
		return camasUrgenciaCantidad;
	}

	public void setCamasUrgenciaCantidad(Integer camasUrgenciaCantidad) {
		this.camasUrgenciaCantidad = camasUrgenciaCantidad;
	}

	public Boolean getCamasUnidadTerapiaIntensiva() {
		return camasUnidadTerapiaIntensiva;
	}

	public void setCamasUnidadTerapiaIntensiva(Boolean camasUnidadTerapiaIntensiva) {
		this.camasUnidadTerapiaIntensiva = camasUnidadTerapiaIntensiva;
	}

	public Integer getCamasUnidadTerapiaIntensivaCantidad() {
		return camasUnidadTerapiaIntensivaCantidad;
	}

	public void setCamasUnidadTerapiaIntensivaCantidad(Integer camasUnidadTerapiaIntensivaCantidad) {
		this.camasUnidadTerapiaIntensivaCantidad = camasUnidadTerapiaIntensivaCantidad;
	}

	public Boolean getConsultorioClinicaMedica() {
		return consultorioClinicaMedica;
	}

	public void setConsultorioClinicaMedica(Boolean consultorioClinicaMedica) {
		this.consultorioClinicaMedica = consultorioClinicaMedica;
	}

	public Integer getConsultorioClinicaMedicaCantidad() {
		return consultorioClinicaMedicaCantidad;
	}

	public void setConsultorioClinicaMedicaCantidad(Integer consultorioClinicaMedicaCantidad) {
		this.consultorioClinicaMedicaCantidad = consultorioClinicaMedicaCantidad;
	}

	public Boolean getConsultorioPediatria() {
		return consultorioPediatria;
	}

	public void setConsultorioPediatria(Boolean consultorioPediatria) {
		this.consultorioPediatria = consultorioPediatria;
	}

	public Integer getConsultorioPediatriaCantidad() {
		return consultorioPediatriaCantidad;
	}

	public void setConsultorioPediatriaCantidad(Integer consultorioPediatriaCantidad) {
		this.consultorioPediatriaCantidad = consultorioPediatriaCantidad;
	}

	public Boolean getConsultorioCirugia() {
		return consultorioCirugia;
	}

	public void setConsultorioCirugia(Boolean consultorioCirugia) {
		this.consultorioCirugia = consultorioCirugia;
	}

	public Integer getConsultorioCirugiaCantidad() {
		return consultorioCirugiaCantidad;
	}

	public void setConsultorioCirugiaCantidad(Integer consultorioCirugiaCantidad) {
		this.consultorioCirugiaCantidad = consultorioCirugiaCantidad;
	}

	public Boolean getConsultorioGinecoObstetricia() {
		return consultorioGinecoObstetricia;
	}

	public void setConsultorioGinecoObstetricia(Boolean consultorioGinecoObstetricia) {
		this.consultorioGinecoObstetricia = consultorioGinecoObstetricia;
	}

	public Integer getConsultorioGinecoObstetriciaCantidad() {
		return consultorioGinecoObstetriciaCantidad;
	}

	public void setConsultorioGinecoObstetriciaCantidad(Integer consultorioGinecoObstetriciaCantidad) {
		this.consultorioGinecoObstetriciaCantidad = consultorioGinecoObstetriciaCantidad;
	}

	public Boolean getLaboratorios() {
		return laboratorios;
	}

	public void setLaboratorios(Boolean laboratorios) {
		this.laboratorios = laboratorios;
	}

	public Integer getLaboratoriosCantidad() {
		return laboratoriosCantidad;
	}

	public void setLaboratoriosCantidad(Integer laboratoriosCantidad) {
		this.laboratoriosCantidad = laboratoriosCantidad;
	}

	public Boolean getConsultorioOdontologicos() {
		return consultorioOdontologicos;
	}

	public void setConsultorioOdontologicos(Boolean consultorioOdontologicos) {
		this.consultorioOdontologicos = consultorioOdontologicos;
	}

	public Integer getConsultorioOdontologicosCantidad() {
		return consultorioOdontologicosCantidad;
	}

	public void setConsultorioOdontologicosCantidad(Integer consultorioOdontologicosCantidad) {
		this.consultorioOdontologicosCantidad = consultorioOdontologicosCantidad;
	}

	public Boolean getSalasRxMamografia() {
		return salasRxMamografia;
	}

	public void setSalasRxMamografia(Boolean salasRxMamografia) {
		this.salasRxMamografia = salasRxMamografia;
	}

	public Integer getSalasRxMamografiaCantidad() {
		return salasRxMamografiaCantidad;
	}

	public void setSalasRxMamografiaCantidad(Integer salasRxMamografiaCantidad) {
		this.salasRxMamografiaCantidad = salasRxMamografiaCantidad;
	}

	public Boolean getConsultorioPsicologia() {
		return consultorioPsicologia;
	}

	public void setConsultorioPsicologia(Boolean consultorioPsicologia) {
		this.consultorioPsicologia = consultorioPsicologia;
	}

	public Integer getConsultorioPsicologiaCantidad() {
		return consultorioPsicologiaCantidad;
	}

	public void setConsultorioPsicologiaCantidad(Integer consultorioPsicologiaCantidad) {
		this.consultorioPsicologiaCantidad = consultorioPsicologiaCantidad;
	}

	public Boolean getConsultorioNutricion() {
		return consultorioNutricion;
	}

	public void setConsultorioNutricion(Boolean consultorioNutricion) {
		this.consultorioNutricion = consultorioNutricion;
	}

	public Integer getConsultorioNutricionCantidad() {
		return consultorioNutricionCantidad;
	}

	public void setConsultorioNutricionCantidad(Integer consultorioNutricionCantidad) {
		this.consultorioNutricionCantidad = consultorioNutricionCantidad;
	}

	public Boolean getConsultorioFisioterapia() {
		return consultorioFisioterapia;
	}

	public void setConsultorioFisioterapia(Boolean consultorioFisioterapia) {
		this.consultorioFisioterapia = consultorioFisioterapia;
	}

	public Integer getConsultorioFisioterapiaCantidad() {
		return consultorioFisioterapiaCantidad;
	}

	public void setConsultorioFisioterapiaCantidad(Integer consultorioFisioterapiaCantidad) {
		this.consultorioFisioterapiaCantidad = consultorioFisioterapiaCantidad;
	}

	public Boolean getConsultorioKinesiologia() {
		return consultorioKinesiologia;
	}

	public void setConsultorioKinesiologia(Boolean consultorioKinesiologia) {
		this.consultorioKinesiologia = consultorioKinesiologia;
	}

	public Integer getConsultorioKinesiologiaCantidad() {
		return consultorioKinesiologiaCantidad;
	}

	public void setConsultorioKinesiologiaCantidad(Integer consultorioKinesiologiaCantidad) {
		this.consultorioKinesiologiaCantidad = consultorioKinesiologiaCantidad;
	}

	public Boolean getFarmacias() {
		return farmacias;
	}

	public void setFarmacias(Boolean farmacias) {
		this.farmacias = farmacias;
	}

	public Integer getFarmaciasCantidad() {
		return farmaciasCantidad;
	}

	public void setFarmaciasCantidad(Integer farmaciasCantidad) {
		this.farmaciasCantidad = farmaciasCantidad;
	}

	public Boolean getQuirofanos() {
		return quirofanos;
	}

	public void setQuirofanos(Boolean quirofanos) {
		this.quirofanos = quirofanos;
	}

	public Integer getQuirofanosCantidad() {
		return quirofanosCantidad;
	}

	public void setQuirofanosCantidad(Integer quirofanosCantidad) {
		this.quirofanosCantidad = quirofanosCantidad;
	}

	public Boolean getSalasParto() {
		return salasParto;
	}

	public void setSalasParto(Boolean salasParto) {
		this.salasParto = salasParto;
	}

	public Integer getSalasPartoCantidad() {
		return salasPartoCantidad;
	}

	public void setSalasPartoCantidad(Integer salasPartoCantidad) {
		this.salasPartoCantidad = salasPartoCantidad;
	}

	public Boolean getAulas() {
		return aulas;
	}

	public void setAulas(Boolean aulas) {
		this.aulas = aulas;
	}

	public Integer getAulasCantidad() {
		return aulasCantidad;
	}

	public void setAulasCantidad(Integer aulasCantidad) {
		this.aulasCantidad = aulasCantidad;
	}

	public Boolean getBibliotecas() {
		return bibliotecas;
	}

	public void setBibliotecas(Boolean bibliotecas) {
		this.bibliotecas = bibliotecas;
	}

	public Integer getBibliotecasCantidad() {
		return bibliotecasCantidad;
	}

	public void setBibliotecasCantidad(Integer bibliotecasCantidad) {
		this.bibliotecasCantidad = bibliotecasCantidad;
	}

	public boolean isAreasDescanso() {
		return areasDescanso;
	}

	public void setAreasDescanso(boolean areasDescanso) {
		this.areasDescanso = areasDescanso;
	}

	public Integer getAreasDescansoCantidad() {
		return areasDescansoCantidad;
	}

	public void setAreasDescansoCantidad(Integer areasDescansoCantidad) {
		this.areasDescansoCantidad = areasDescansoCantidad;
	}

	public Boolean getVestidores() {
		return vestidores;
	}

	public void setVestidores(Boolean vestidores) {
		this.vestidores = vestidores;
	}

	public Integer getVestidoresCantidad() {
		return vestidoresCantidad;
	}

	public void setVestidoresCantidad(Integer vestidoresCantidad) {
		this.vestidoresCantidad = vestidoresCantidad;
	}

	public Boolean getComedores() {
		return comedores;
	}

	public void setComedores(Boolean comedores) {
		this.comedores = comedores;
	}

	public Integer getComedoresCantidad() {
		return comedoresCantidad;
	}

	public void setComedoresCantidad(Integer comedoresCantidad) {
		this.comedoresCantidad = comedoresCantidad;
	}

    
}
