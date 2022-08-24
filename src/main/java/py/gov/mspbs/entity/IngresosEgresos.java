package py.gov.mspbs.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "ingresosegresos")
public class IngresosEgresos extends AuditBaseEntity implements Serializable {

    private static final long serialVersionUID = -661899086717477613L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }

    @NotNull(message = "El campo año es un campo requerido")
    @Column(nullable = false)
    Integer año;

    Integer numeroIngresos;

    Integer numeroEgresos;

    String duracionCicloFormativo;

    String titulacionOtorgada;

    public Integer getAño() {
        return año;
    }
    public void setAño(Integer año) {
        this.año = año;
    }

    public Integer getNumeroIngresos() {
        return numeroIngresos;
    }
    public void setNumeroIngresos(Integer numeroIngresos) {
        this.numeroIngresos = numeroIngresos;
    }

    public Integer getNumeroEgresos() {
        return numeroEgresos;
    }
    public void setNumeroEgresos(Integer numeroEgresos) {
        this.numeroEgresos = numeroEgresos;
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
}



