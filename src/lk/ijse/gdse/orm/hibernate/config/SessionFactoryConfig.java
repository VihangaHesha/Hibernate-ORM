package lk.ijse.gdse.orm.hibernate.config;

import lk.ijse.gdse.orm.hibernate.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SessionFactoryConfig {
    private static SessionFactoryConfig factoryConfig;
    private final SessionFactory sessionFactory;

    private SessionFactoryConfig() {
        sessionFactory =new MetadataSources(new StandardServiceRegistryBuilder()
                .configure()
                .build())
                .addAnnotatedClass(Customer.class)
                .getMetadataBuilder()
                .build().buildSessionFactory();
    }

    public static SessionFactoryConfig getInstance() {
        return (null == factoryConfig) ? factoryConfig = new SessionFactoryConfig() : factoryConfig;
    }

    //    In here we need to import the hibernate.org package and no other
    public Session getSession() {
        return sessionFactory.openSession();

        /*

       ---- we can do this too instead of doing above ----

        return metadata.buildSessionFactory().openSession();

        */
    }
}
