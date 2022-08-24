package py.gov.mspbs.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "establecimientos_carreras_plazas_observaciones")
public class EstablecimientosCarrerasPlazasObservaciones extends AuditBaseEntity implements Serializable {

    private static final long serialVersionUID = 4765610723749482803L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull(message = "El campo Establecimientos Carreras Plazas es un campo requerido")
    @ManyToOne
	@JoinColumn(name = "establecimiento_carrera_plaza_id", nullable = false)
    private EstablecimientosCarrerasPlazas establecimientoCarreraPlaza;

    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSS")
    private Date fechaObservacion;

    @NotNull(message = "El campo observacion es un campo requerido")
    private String observacion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EstablecimientosCarrerasPlazas getEstablecimientoCarreraPlaza() {
        return establecimientoCarreraPlaza;
    }

    public void setEstablecimientoCarreraPlaza(EstablecimientosCarrerasPlazas establecimientoCarreraPlaza) {
        this.establecimientoCarreraPlaza = establecimientoCarreraPlaza;
    }

    public Date getFechaObservacion() {
        return fechaObservacion;
    }

    public void setFechaObservacion(Date fechaObservacion) {
        this.fechaObservacion = fechaObservacion;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
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
		EstablecimientosCarrerasPlazasObservaciones other = (EstablecimientosCarrerasPlazasObservaciones) obj;
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
		return "EstablecimientosCarrerasPlazasObservaciones [id=" + id +"]";
	}
    
}