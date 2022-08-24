package py.gov.mspbs.entity;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "convenio_ingresosegresos")
public class ConvenioIngresosEgresos extends AuditBaseEntity implements Serializable {

    private static final long serialVersionUID = 1316228540128572513L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "convenio_id")
    private Convenio convenio;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ingresosegresos_id")
    private IngresosEgresos ingresosEgresos;

    public Convenio getConvenio() {
        return convenio;
    }

    public void setConvenio(Convenio convenio) {
        this.convenio = convenio;
    }

    public IngresosEgresos getIngresosEgresos() {
        return ingresosEgresos;
    }

    public void setIngresosEgresos(IngresosEgresos ingresosEgresos) {
        this.ingresosEgresos = ingresosEgresos;
    }
}
