package lk.ijse.gdse.orm.hibernate;

import lk.ijse.gdse.orm.hibernate.config.SessionFactoryConfig;
import lk.ijse.gdse.orm.hibernate.entity.Customer;
import org.hibernate.Session;

import java.util.ArrayList;

public class DetachedState {
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

        //Now the object is in the Persistent State
        int cusId  = (int) session.save(customer);
        System.out.println("Customer Id :" + cusId);

        System.out.println(isExistInSession(session, customer));
        session.close();


        Session detachedSession =
                SessionFactoryConfig
                        .getInstance()
                        .getSession();

        //Now the object is in the Detached State
        //Persistent State -> Detached State
        detachedSession.detach(customer);
        System.out.println(isExistInSession(detachedSession, customer));


        //Now the object is in the Persistent State again!!
        //Persistent State -> Detached State -> Persistent State
        customer.setAddress("Matara");
        detachedSession.save(customer);

        System.out.println(isExistInSession(detachedSession, customer));
    }
    private static String isExistInSession(Session session, Customer customer){
        return session.contains(customer)
                ? "This object is in the Persistent State"
                : "This object is in the Detached State";
    }
}
