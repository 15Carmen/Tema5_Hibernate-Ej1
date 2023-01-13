import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "Email")
public class Email implements Serializable {

    @Id
    @Column(name = "idAlum")
    private int idAlum;

    @Id
    @Column(name = "idEmail")
    private int idEmail;

    @Column(name = "email")
    private String email;

    @ManyToOne
    @JoinColumn(name = "idAlum")
    private Alumnado alumnado;

    public Email(int idAlum, int idEmail, String email, Alumnado alumnado) {
        this.idAlum = idAlum;
        this.idEmail = idEmail;
        this.email = email;
        this.alumnado = alumnado;
    }

    public Email() {

    }

    public Alumnado getAlumnado() {
        return alumnado;
    }

    public void setAlumnado(Alumnado alumnado) {
        this.alumnado = alumnado;
    }
}