import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
@Entity
@Table(name="Alumnado")
public class Alumnado implements Serializable  {

    @Id
    @Column(name="IdAlum")
    private int idAlum;

    @Column(name="nombre")
    private String nombre;

    @Column(name="ape1")
    private String ape1;

    @Column(name="ape2")
    private String ape2;

    @OneToOne(cascade=CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Direccion direccion;
    public Alumnado(){
    }

    @OneToMany(cascade= CascadeType.ALL)
    @JoinColumn(name="idAlum")
    private List<Email> listaEmails;

    public Alumnado(int idAlum, String nombre, String ape1, String ape2) {
        this.idAlum = idAlum;
        this.nombre = nombre;
        this.ape1 = ape1;
        this.ape2 = ape2;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public List<Email> getListaEmails() {
        return listaEmails;
    }

    public void setListaEmails(List<Email> listaEmails) {
        this.listaEmails = listaEmails;
    }
}
