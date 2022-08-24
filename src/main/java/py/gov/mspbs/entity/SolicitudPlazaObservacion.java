package py.gov.mspbs.entity;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "solicitudes_plazas_observaciones")
public class SolicitudPlazaObservacion extends AuditBaseEntity implements Serializable {

    private static final long serialVersionUID = 1316228540128572513L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "solicitud_plaza_id")
    private SolicitudPlaza solicitudPlaza;

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

    public SolicitudPlaza getSolicitudPlaza() {
        return solicitudPlaza;
    }

    public void setSolicitudPlaza(SolicitudPlaza solicitudPlaza) {
        this.solicitudPlaza = solicitudPlaza;
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
		SolicitudPlazaObservacion other = (SolicitudPlazaObservacion) obj;
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
		return "SolicitudPlazaOpservacion [id=" + id +"]";
	}   

}
