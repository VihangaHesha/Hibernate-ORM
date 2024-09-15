package lk.ijse.gdse.orm.hibernate;

import lk.ijse.gdse.orm.hibernate.config.SessionFactoryConfig;
import lk.ijse.gdse.orm.hibernate.entity.Customer;
import org.hibernate.Session;

import java.util.ArrayList;

public class TransientState {
    public static void main(String[] args) {
        Session session =
                SessionFactoryConfig
                        .getInstance()
                        .getSession();

        // Transient State
        Customer customer = new Customer(
                1,
                "Malee",
                "Galle",
                new ArrayList<>());
        System.out.println(isExistInSession(session,customer));
    }

    private static String isExistInSession(Session session, Customer customer){
        return session.contains(customer)
                ? "This is not transient"
                : "This object is Transient";
    }
}
