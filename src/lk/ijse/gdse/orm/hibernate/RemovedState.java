package lk.ijse.gdse.orm.hibernate;

import lk.ijse.gdse.orm.hibernate.config.SessionFactoryConfig;
import lk.ijse.gdse.orm.hibernate.entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class RemovedState {
    public static void main(String[] args) {

        //Now the object is in the Persistent State
        //Transient State -> Persistent State
        Session session =
                SessionFactoryConfig
                        .getInstance()
                        .getSession();

        Transaction transaction = session.beginTransaction();
        Customer customer = session.get(Customer.class, 1);
        System.out.println(isExistInSession(session, customer));

        //Now the Object is in the Removed State
        //Persistent State -> Removed State
        session.delete(customer);
        System.out.println(isExistInSession(session, customer));

        transaction.commit();
        session.close();
    }
    private static String isExistInSession(Session session, Customer customer){
        return session.contains(customer)
                ? "This Object is in the Persistent State"
                : "This object is in The Removed State";
    }
}
