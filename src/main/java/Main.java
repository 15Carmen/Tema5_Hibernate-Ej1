import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static SessionFactory sessionFactory;

    public static void main(String[] args) {

        setUp();
        //insertarAlumno2();
        insertarAlumno3();

    }



    public static void insertarAlumno2(){
        Direccion direccion1=new Direccion(3, "Calle de la sarten", 23, "Manises", "Valencia");
        Alumnado alumnado1=new Alumnado(3, "Sergio", "Mateo", "Ramis");
        alumnado1.setDireccion(direccion1);
        direccion1.setAlumnado(alumnado1);
        Direccion direccion2=new Direccion(4, "Calle Luis lamarca", 45, "Torrente", "Valencia");
        Alumnado alumnado2=new Alumnado(4, "Paco", "Moreno", "Díaz");
        alumnado2.setDireccion(direccion2);
        direccion2.setAlumnado(alumnado2);

        Session session=sessionFactory.openSession();
        session.beginTransaction();

        session.save(alumnado1);
        session.save(alumnado2);
        session.save(direccion1);
        session.save(direccion2);

        session.getTransaction().commit();
        session.close();
    }

    public static void insertarAlumno3(){
        Alumnado alumnado=new Alumnado(9, "Rosa", "Díaz", "Del Toro");
        List<Email> email=new ArrayList<>();
        email.add(new Email(3, 1, "rosa@yahoo.com",alumnado));
        email.add(new Email(2, 2,"rosa@hotmail.com",alumnado));
        email.add(new Email(1, 3,"rosa@gmail.com",alumnado));

        alumnado.setListaEmails(email);

        Session session=sessionFactory.openSession();
        session.beginTransaction();

        session.save(alumnado);

        session.getTransaction().commit();
        session.close();
    }

    protected static void setUp() {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // por defecto: hibernate.cfg.xml
                .build();
        try {
            sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
        }
        catch (Exception e) {
            StandardServiceRegistryBuilder.destroy( registry );
        }
    }
}
