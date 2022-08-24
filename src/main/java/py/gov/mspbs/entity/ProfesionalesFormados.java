package py.gov.mspbs.entity;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "profesionales_formados")
public class ProfesionalesFormados implements Serializable {

    private static final long serialVersionUID = 8190915098437257922L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "convenio_id")
    @Valid
    @NotNull(message = "El campo Convenio es requerido")
    private Convenio convenio;

    @ManyToOne
    @JoinColumn(name = "carreraprograma_id")
    @NotNull(message = "El campo Carrera es requerido")
    private CarreraPrograma carrera;

    @NotNull(message = "El campo Duración del Ciclo Formativo es  requerido")
    private String duracionCicloFormativo;

    @NotNull(message = "El campo Titulación Otorgada es requerido")
    private String titulacionOtorgada;
 
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "profesionales_formados_id")
    @Valid
    @NotNull(message = "El listado de datos estadísticos por año es requerido por Año es requerido")
    private List<ProfesionalesFormadosAnio> listaTotalesProfesionalesAnios;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Convenio getConvenio() {
        return convenio;
    }

    public void setConvenio(Convenio convenio) {
        this.convenio = convenio;
    }

    public CarreraPrograma getCarrera() {
        return carrera;
    }

    public void setCarrera(CarreraPrograma carrera) {
        this.carrera = carrera;
    }

    public String getDuracionCicloFormativo() {
		return duracionCicloFormativo;
	}

	public void setDuracionCicloFormativo(String duracionCicloFormativo) {
		this.duracionCicloFormativo = duracionCicloFormativo;
	}

	public String getTitulacionOtorgada() {
        return titulacionOtorgada;
    }

    public void setTitulacionOtorgada(String titulacionOtorgada) {
        this.titulacionOtorgada = titulacionOtorgada;
    }
   
	public List<ProfesionalesFormadosAnio> getListaTotalesProfesionalesAnios() {
        return listaTotalesProfesionalesAnios;
    }

    public void setListaTotalesProfesionalesAnios(List<ProfesionalesFormadosAnio> listaTotalesProfesionalesAnios) {
        this.listaTotalesProfesionalesAnios = listaTotalesProfesionalesAnios;
    }

}
