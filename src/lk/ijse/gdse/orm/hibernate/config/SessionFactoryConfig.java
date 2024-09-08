package lk.ijse.gdse.orm.hibernate.config;

import lk.ijse.gdse.orm.hibernate.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class SessionFactoryConfig {
    private static SessionFactoryConfig factoryConfig;
    private final SessionFactory sessionFactory;

    private SessionFactoryConfig() {
       /*
        ========== Native Bootstrapping Method ==========
        sessionFactory =new MetadataSources(new StandardServiceRegistryBuilder()
                .configure()
                .build())
                .addAnnotatedClass(Customer.class)
                .getMetadataBuilder()
                .build().buildSessionFactory();*/


//       ========== Configuration Object Method ==========
        sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(Customer.class)
                .buildSessionFactory();
    }

    public static SessionFactoryConfig getInstance() {
        return (null == factoryConfig) ? factoryConfig = new SessionFactoryConfig() : factoryConfig;
    }

    public Session getSession() {
       /*

        //        01.Created a service registry as the step one
        StandardServiceRegistry serviceRegistry =
                new StandardServiceRegistryBuilder()
                        .configure()
                        .build();

        *//*
        When we changed the file path or changed the name of the xml file we have to call this
        configure method !!!

        .configure(XML file path)

        *//*

//        02.Create a MetaData Object
        Metadata metadata =
                new MetadataSources(serviceRegistry)
                        .addAnnotatedClass(Customer.class)
                        .getMetadataBuilder()
                        .build();

//        03.Create a SessionFactory Object
        SessionFactory sessionFactory =
                metadata
                        .buildSessionFactory();

        return sessionFactory.openSession();

        */

        return sessionFactory.openSession();

    }
}
