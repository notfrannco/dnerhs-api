package py.gov.mspbs.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "practica_detalle")
public class PracticaDetalle extends AuditBaseEntity implements Serializable {

    private static final long serialVersionUID = 8629510556768761879L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // @Pattern(regexp="^(19|20)[\\d]{2,2}$")
    @NotNull(message = "El campo Año es un campo requerido")
    private Integer anio;

    @NotNull(message = "El campo Total de Horas es un campo requerido")
    private Integer totalHoras;

    @NotNull(message = "El campo Estudiante es un campo requerido")
    @ManyToOne
    @JoinColumn(name = "convenio_estudiante_id")
    private ConvenioEstudiante convenioEstudiante;

    @NotNull(message = "El campo Tutor es un campo requerido")
    @ManyToOne
    @JoinColumn(name = "convenio_tutor_id")
    private ConvenioTutor convenioTutor;

    @NotNull(message = "El campo Campo de Práctica es un campo requerido")
    @ManyToOne
    @JoinColumn(name = "instituciones_establecimientos_id")
    private InstitucionEstablecimiento establecimiento;

    @NotNull(message = "El campo Campo de Solicitud Plaza es un campo requerido")
    @ManyToOne
    @JoinColumn(name = "solicitud_plaza_id")
    private SolicitudPlaza solicitudPlaza;

    private Boolean modificado;

    private Boolean confirmacion;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    private Date fechaConfirmacion;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    private Date fechaDesde;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    private Date fechaHasta;

    // @NotNull(message = "El Listado de dias con sus datos de prácticas son
    // requeridos")
    /**
    *
    */
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "practica_detalle_id")
    private List<PracticaDetalleHorario> practicaDetalleHorarioList;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public ConvenioEstudiante getConvenioEstudiante() {
        return convenioEstudiante;
    }

    public void setConvenioEstudiante(ConvenioEstudiante convenioEstudiante) {
        this.convenioEstudiante = convenioEstudiante;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public Integer getTotalHoras() {
        return totalHoras;
    }

    public void setTotalHoras(Integer totalHoras) {
        this.totalHoras = totalHoras;
    }

    public ConvenioTutor getConvenioTutor() {
        return convenioTutor;
    }

    public void setConvenioTutor(ConvenioTutor convenioTutor) {
        this.convenioTutor = convenioTutor;
    }

    public InstitucionEstablecimiento getEstablecimiento() {
        return establecimiento;
    }

    public void setEstablecimiento(InstitucionEstablecimiento establecimiento) {
        this.establecimiento = establecimiento;
    }

    public SolicitudPlaza getSolicitudPlaza() {
        return solicitudPlaza;
    }

    public void setSolicitudPlaza(SolicitudPlaza solicitudPlaza) {
        this.solicitudPlaza = solicitudPlaza;
    }

    public Boolean getModificado() {
        return modificado;
    }

    public void setModificado(Boolean modificado) {
        this.modificado = modificado;
    }

    public Boolean getConfirmacion() {
        return confirmacion;
    }

    public void setConfirmacion(Boolean confirmacion) {
        this.confirmacion = confirmacion;
    }

    public Date getFechaConfirmacion() {
        return fechaConfirmacion;
    }

    public void setFechaConfirmacion(Date fechaConfirmacion) {
        this.fechaConfirmacion = fechaConfirmacion;
    }

    public Date getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(Date fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public Date getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(Date fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    public List<PracticaDetalleHorario> getPracticaDetalleHorarioList() {
        return practicaDetalleHorarioList;
    }

    public void setPracticaDetalleHorarioList(List<PracticaDetalleHorario> practicaDetalleHorarioList) {
        this.practicaDetalleHorarioList = practicaDetalleHorarioList;
    }

}
