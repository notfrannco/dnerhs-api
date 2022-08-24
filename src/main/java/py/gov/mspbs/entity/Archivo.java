package py.gov.mspbs.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "archivo")
public class Archivo extends AuditBaseEntity implements Serializable {

    private static final long serialVersionUID = 6946387875684478763L;

    @Id
    private String id;

    private String nombreOriginal;

    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }
	public String getNombreOriginal() {
		return nombreOriginal;
	}
	
	public void setNombreOriginal(String nombreOriginal) {
		this.nombreOriginal = nombreOriginal;
	}
	
}