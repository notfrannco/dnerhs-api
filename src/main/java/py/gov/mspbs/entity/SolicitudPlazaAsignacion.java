package py.gov.mspbs.entity;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.io.Serializable;
import java.sql.Time;

@Entity
@Table(name = "solicitudes_plazas_asignaciones")
public class SolicitudPlazaAsignacion extends AuditBaseEntity implements Serializable {

    private static final long serialVersionUID = 1316228540128572513L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "solicitud_plaza_id")
    private SolicitudPlaza solicitudPlaza;

    @Column(nullable = false, length=10)
	private String dia;

    @Column(nullable = false)
	private Time horarioDesde;

    @Column(nullable = false)
	private Time horarioHasta;

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

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public Time getHorarioDesde() {
        return horarioDesde;
    }

    public void setHorarioDesde(Time horarioDesde) {
        this.horarioDesde = horarioDesde;
    }

    public Time getHorarioHasta() {
        return horarioHasta;
    }

    public void setHorarioHasta(Time horarioHasta) {
        this.horarioHasta = horarioHasta;
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
		SolicitudPlazaAsignacion other = (SolicitudPlazaAsignacion) obj;
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
		return "SolicitudPlazaAsignacion [id=" + id +"]";
	}   

}
