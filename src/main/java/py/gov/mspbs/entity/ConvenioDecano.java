package py.gov.mspbs.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "convenio_decano")
public class ConvenioDecano extends AuditBaseEntity implements Serializable {

    private static final long serialVersionUID = 7840907179764511850L;

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

    @ManyToOne
    @JoinColumn(name = "convenio_id")
    private Convenio convenio;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "decano_id")
    private Decano decano;

    public Convenio getConvenio() {
        return convenio;
    }
    public void setConvenio(Convenio convenio) {
        this.convenio = convenio;
    }

    public Decano getDecano() {
        return decano;
    }
    public void setDecano(Decano decano) {
        this.decano = decano;
    }
}
