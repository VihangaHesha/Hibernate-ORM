package lk.ijse.gdse.orm.hibernate.config;

import lk.ijse.gdse.orm.hibernate.entity.Customer;
import org.hibernate.Session;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.util.Properties;

public class SessionFactory {
    private static SessionFactory factoryConfig;
    private org.hibernate.SessionFactory sessionFactory;

    private SessionFactory(){
        Configuration configuration = new Configuration();

        Properties properties = new Properties();

        try {
            properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("lk/ijse/gdse/orm/hibernate/hibernate.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        configuration.setProperties(properties);

        configuration.addAnnotatedClass(Customer.class);

        sessionFactory = configuration.buildSessionFactory();


    }

    public static SessionFactory getInstance(){
        return (null == factoryConfig ) ? factoryConfig = new SessionFactory() : factoryConfig;
    }
       public Session getSession(){

        return sessionFactory.openSession();
    }
}
