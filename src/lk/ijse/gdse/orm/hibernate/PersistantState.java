package lk.ijse.gdse.orm.hibernate;

import lk.ijse.gdse.orm.hibernate.config.SessionFactoryConfig;
import lk.ijse.gdse.orm.hibernate.entity.Customer;
import org.hibernate.Session;

import java.io.Serializable;
import java.util.ArrayList;

public class PersistantState {
    public static void main(String[] args) {
        Session session =
                SessionFactoryConfig
                        .getInstance()
                        .getSession();

        // Now the object is in the Transient State
        Customer customer = new Customer(
                2,
                "Malee",
                "Galle",
                new ArrayList<>());

        int cusId  = (int) session.save(customer);
        System.out.println("Customer Id :" + cusId);
        System.out.println(isExistInSession(session, customer));

    }
    private static String isExistInSession(Session session, Customer customer){
        return session.contains(customer)
                ? "This object is in the Persistent State"
                : "This object is still in the Transient";
    }
}
