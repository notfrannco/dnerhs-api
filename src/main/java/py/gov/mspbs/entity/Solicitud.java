package py.gov.mspbs.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "convenio_solicitud")
public class Solicitud extends AuditBaseEntity implements Serializable {

    private static final long serialVersionUID = -7075991744376406170L;

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

    @OneToOne
    @JoinColumn(name = "convenio_id", nullable = false)
    private Convenio convenio;

    private String solicitud;

    public Convenio getConvenio() {
        return convenio;
    }

    public void setConvenio(Convenio convenio) {
        this.convenio = convenio;
    }

    public String getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(String solicitud) {
        this.solicitud = solicitud;
    }
}
