package py.gov.mspbs.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "solicitudes_plazas")
public class SolicitudPlaza extends AuditBaseEntity implements Serializable {

    private static final long serialVersionUID = -6244779839889393522L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El campo ID dato establecimiento es un campo requerido.")
	@ManyToOne
	@JoinColumn(name = "datos_establecimiento_id")
	private DatosEstablecimiento datosEstablecimiento;

    @NotNull(message = "El campo Carrera Programa es un campo requerido")
    @ManyToOne
	@JoinColumn(name = "carreraprograma_id")
    private CarreraPrograma carreraprograma;

    private Integer anio;
    private Integer lugaresSolicitados;
    private String estado;

    @NotNull(message = "El campo ID convenio es un campo requerido.")
	@ManyToOne
	@JoinColumn(name = "convenio_id")
	private Convenio convenio;
    
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "solicitud_plaza_id")
    private List<SolicitudPlazaAsignacion> solicitudPlazaAsignacionList;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public DatosEstablecimiento getDatosEstablecimiento() {
        return datosEstablecimiento;
    }

    public void setDatosEstablecimiento(DatosEstablecimiento datosEstablecimiento) {
        this.datosEstablecimiento = datosEstablecimiento;
    }

    public CarreraPrograma getCarreraprograma() {
        return carreraprograma;
    }

    public void setCarreraprograma(CarreraPrograma carreraprograma) {
        this.carreraprograma = carreraprograma;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public Integer getLugaresSolicitados() {
        return lugaresSolicitados;
    }

    public void setLugaresSolicitados(Integer lugaresSolicitados) {
        this.lugaresSolicitados = lugaresSolicitados;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Convenio getConvenio() {
        return convenio;
    }

    public void setConvenio(Convenio convenio) {
        this.convenio = convenio;
    }

    public List<SolicitudPlazaAsignacion> getSolicitudPlazaAsignacionList() {
        return solicitudPlazaAsignacionList;
    }

    public void setSolicitudPlazaAsignacionList(List<SolicitudPlazaAsignacion> solicitudPlazaAsignacionList) {
        this.solicitudPlazaAsignacionList = solicitudPlazaAsignacionList;
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
		SolicitudPlaza other = (SolicitudPlaza) obj;
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
		return "SolicitudPlaza [id=" + id +"]";
	}   

}
