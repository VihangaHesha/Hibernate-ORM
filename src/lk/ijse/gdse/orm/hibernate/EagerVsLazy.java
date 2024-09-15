package lk.ijse.gdse.orm.hibernate;

import lk.ijse.gdse.orm.hibernate.config.SessionFactoryConfig;
import lk.ijse.gdse.orm.hibernate.entity.Customer;
import org.hibernate.Session;

public class EagerVsLazy {
    public static void main(String[] args) {

        Session saveSession =
                SessionFactoryConfig
                        .getInstance()
                        .getSession();

        Customer customer = new Customer();
        customer.setName("Sunil");
        customer.setAddress("Galle");

        saveSession.save(customer);

        saveSession.close();

//        01. Get method - EAGER FetchType

        Session getSession =
                SessionFactoryConfig
                .getInstance()
                .getSession();

        System.out.println("--------------------- Calling Get Method ----------------------");
        Customer existingGetCustomer =
                getSession
                        .get(Customer.class, 1);
        System.out.println("Customer Id Of Get :" + existingGetCustomer.getId());
        System.out.println("Customer Name Of Get : " + existingGetCustomer.getName());

        getSession.close();

//        02. Load Method - LAZY FetchType

        Session loadSession =
                SessionFactoryConfig
                        .getInstance()
                        .getSession();
        System.out.println("--------------------- Calling Load Method ----------------------");
        Customer existingLoadCustomer =
                loadSession
                        .load(Customer.class, 1);

        System.out.println("Customer Id Of Load :" + existingLoadCustomer.getId());
        System.out.println("Customer Name Of Load : " + existingLoadCustomer.getName());

        loadSession.close();
    }
}
