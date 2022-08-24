package py.gov.mspbs.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "constancia")
public class Constancia implements Serializable  {
    private static final long serialVersionUID = -10827621996916655L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotNull(message = "El campo Cédula de identidad es un campo requerido")
    private Integer cedulaIdentidad;

    @NotNull(message = "El campo Nombres es un campo requerido")
    private String nombres;

    @NotNull(message = "El campo Apellidos es un campo requerido")
    private String apellidos;

    @ManyToOne
    @JoinColumn(name = "carreraprograma_id")
    @NotNull(message = "El campo Carrera/Programa es un campo requerido")
    private CarreraPrograma carrera;
    
    @ManyToOne
    @JoinColumn(name = "institucion_formadora_id")
    @NotNull(message = "El campo Institución formadora es un campo requerido")
    private InstitucionFormadora institucionFormadora;

    @ManyToOne
    @JoinColumn(name = "nacionalidad_id")
    @NotNull(message = "El campo Nacionalidad es un campo requerido")
    private Nacionalidad nacionalidad;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "constancia_id")
    private List<ConstanciaDetalle> constanciaDetalleList;

    private String codigoEnlace;

    private Date fechaUltimaDescarga;

    public Integer getCedulaIdentidad() {
        return cedulaIdentidad;
    }

    public void setCedulaIdentidad(Integer cedulaIdentidad) {
        this.cedulaIdentidad = cedulaIdentidad;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Nacionalidad getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(Nacionalidad nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public List<ConstanciaDetalle> getConstanciaDetalleList() {
        return constanciaDetalleList;
    }

    public void setConstanciaDetalleList(List<ConstanciaDetalle> constanciaDetalleList) {
        this.constanciaDetalleList = constanciaDetalleList;
    }

    public String getCodigoEnlace() {
        return codigoEnlace;
    }

    public void setCodigoEnlace(String codigoEnlace) {
        this.codigoEnlace = codigoEnlace;
    }
    
    public InstitucionFormadora getInstitucionFormadora() {
		return institucionFormadora;
	}

	public void setInstitucionFormadora(InstitucionFormadora institucionFormadora) {
		this.institucionFormadora = institucionFormadora;
	}

	public CarreraPrograma getCarrera() {
        return carrera;
    }

    public void setCarrera(CarreraPrograma carrera) {
        this.carrera = carrera;
    }

    public Date getFechaUltimaDescarga() {
        return fechaUltimaDescarga;
    }

    public void setFechaUltimaDescarga(Date fechaUltimaDescarga) {
        this.fechaUltimaDescarga = fechaUltimaDescarga;
    }
}
