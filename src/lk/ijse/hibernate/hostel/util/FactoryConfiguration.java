package lk.ijse.hibernate.hostel.util;

import lk.ijse.hibernate.hostel.entity.test.Customer;
import lk.ijse.hibernate.hostel.entity.test.Orderr;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryConfiguration {
    private static FactoryConfiguration factoryConfiguration;

    private SessionFactory sessionFactory;

    private FactoryConfiguration(){
        Configuration configuration = new Configuration()
               /* .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Room.class)
                .addAnnotatedClass(Reservation.class)
                .addAnnotatedClass(User.class)*/
                .addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Orderr.class);
        sessionFactory = configuration.buildSessionFactory();
    }

    public static FactoryConfiguration getInstance(){
        if(factoryConfiguration==null)factoryConfiguration=new FactoryConfiguration();
        return factoryConfiguration;
    }

    public Session getSession(){
        return sessionFactory.openSession();
    }
}
//manika mt me error ek oya thniym hdla ona