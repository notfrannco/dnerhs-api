package py.gov.mspbs.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "establecimientos_carreras_plazas")
public class EstablecimientosCarrerasPlazas extends AuditBaseEntity implements Serializable {

    private static final long serialVersionUID = 4765610723749482803L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull(message = "El campo Nombre Servicio es un campo requerido")
    @ManyToOne
	@JoinColumn(name = "nombre_servicio_id", nullable = false)
    private NombreServicio nombreServicio;

    @NotNull(message = "El campo Carrera Programa es un campo requerido")
    @ManyToOne
	@JoinColumn(name = "carreraprograma_id", nullable = false)
    private CarreraPrograma carreraprograma;

    @NotNull(message = "El campo carrera programa disponible es un campo requerido")
    private Boolean carreraprogramaDisponible;

    @Column(columnDefinition = "integer default 0")
    private Integer cantidad;
    @Column(columnDefinition = "integer default 0")
    private Integer disponible;
    @Column(columnDefinition = "integer default 0")
    private Integer enGestion;
    @Column(columnDefinition = "integer default 0")
    private Integer ocupadas;
    @Column(columnDefinition = "integer default 0")
    private Integer medicinaAnosInferiores;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public NombreServicio getNombreServicio() {
        return nombreServicio;
    }

    public void setNombreServicio(NombreServicio nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public CarreraPrograma getCarreraprograma() {
        return carreraprograma;
    }

    public void setCarreraprograma(CarreraPrograma carreraprograma) {
        this.carreraprograma = carreraprograma;
    }

    public Boolean getCarreraprogramaDisponible() {
        return carreraprogramaDisponible;
    }

    public void setCarreraprogramaDisponible(Boolean carreraprogramaDisponible) {
        this.carreraprogramaDisponible = carreraprogramaDisponible;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getDisponible() {
        return disponible;
    }

    public void setDisponible(Integer disponible) {
        this.disponible = disponible;
    }

    public Integer getEnGestion() {
        return enGestion;
    }

    public void setEnGestion(Integer enGestion) {
        this.enGestion = enGestion;
    }

    public Integer getOcupadas() {
        return ocupadas;
    }

    public void setOcupadas(Integer ocupadas) {
        this.ocupadas = ocupadas;
    }

    public Integer getMedicinaAnosInferiores() {
        return medicinaAnosInferiores;
    }

    public void setMedicinaAnosInferiores(Integer medicinaAnosInferiores) {
        this.medicinaAnosInferiores = medicinaAnosInferiores;
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
		EstablecimientosCarrerasPlazas other = (EstablecimientosCarrerasPlazas) obj;
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
		return "EstablecimientosCarrerasPlazas [id=" + id +"]";
	}
    
}