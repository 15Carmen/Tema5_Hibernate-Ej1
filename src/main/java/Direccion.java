import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="Direccion")
public class Direccion implements Serializable {


    @Id
    @Column(name = "idAlum")
    private int idAlum;

    @Column(name = "calle")
    private String calle;

    @Column(name = "numero")
    private int numero;

    @Column(name = "poblacion")
    private String poblacion;

    @Column(name = "provincia")
    private String provincia;

    @OneToOne(cascade=CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Alumnado alumnado;

    public Direccion(){
    }

    public Direccion(int idAlum, String calle, int numero, String poblacion, String provincia) {
        this.idAlum = idAlum;
        this.calle = calle;
        this.numero = numero;
        this.poblacion = poblacion;
        this.provincia = provincia;
    }

    public Alumnado getAlumnado() {
        return alumnado;
    }

    public void setAlumnado(Alumnado alumnado) {
        this.alumnado = alumnado;
    }
}
