package py.gov.mspbs.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "profesionales_salud_anio")
public class ProfesionalesFormadosAnio implements Serializable {

    private static final long serialVersionUID = -2430442295419304880L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull(message = "El campo Año es un campo requerido")
    private Integer anio;

    @NotNull(message = "El campo Número de Ingresantes en 1er Curso es un campo requerido")
    private Integer numeroIngresados;

    @NotNull(message = "El campo Número de Egresantes es un campo requerido")
    private Integer numeroEgresados;
    
    @NotNull(message = "El campo Titulación Otorgada es requerido")
    private Integer porcentajeDesercion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public Integer getNumeroIngresados() {
        return numeroIngresados;
    }

    public void setNumeroIngresados(Integer numeroIngresados) {
        this.numeroIngresados = numeroIngresados;
    }

    public Integer getNumeroEgresados() {
        return numeroEgresados;
    }

    public void setNumeroEgresados(Integer numeroEgresados) {
        this.numeroEgresados = numeroEgresados;
    }
    
    public Integer getPorcentajeDesercion() {
		return porcentajeDesercion;
	}

	public void setPorcentajeDesercion(Integer porcentajeDesercion) {
		this.porcentajeDesercion = porcentajeDesercion;
	}
}
