package lk.ijse.gdse.orm.hibernate;

import lk.ijse.gdse.orm.hibernate.config.SessionFactory;
import lk.ijse.gdse.orm.hibernate.entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {
        Session session = SessionFactory.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        Customer customer = new Customer(05,"Kumara","Galle",13000.00);

        session.save(customer);

        transaction.commit();
        session.close();
    }
}