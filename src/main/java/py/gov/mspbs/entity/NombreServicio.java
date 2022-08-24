package py.gov.mspbs.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "nombres_servicios")
public class NombreServicio implements Serializable {
    private static final long serialVersionUID = 5689865922332596362L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String nombre;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
