package py.gov.mspbs.entity;
import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "practica_detalle_horario")
public class PracticaDetalleHorario extends AuditBaseEntity implements Serializable {

    private static final long serialVersionUID = 1316228540128572513L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "practica_detalle_id")
    private PracticaDetalle practicaDetalle;

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

    public PracticaDetalle getPracticaDetalle() {
        return practicaDetalle;
    }

    public void setPracticaDetalle(PracticaDetalle practicaDetalle) {
        this.practicaDetalle = practicaDetalle;
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
		PracticaDetalleHorario other = (PracticaDetalleHorario) obj;
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
		return "PracticaDetalleHorario [id=" + id +"]";
	}   

}
