package lk.ijse.gdse.orm.hibernate;

import lk.ijse.gdse.orm.hibernate.config.SessionFactoryConfig;
import lk.ijse.gdse.orm.hibernate.entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("Kamal");
        customer.setAddress("Galle");
        customer.setSalary(25000.00);

//        We get an instance from the SessionFactory as a Session and refer it to a variable
        Session session = SessionFactoryConfig.getInstance().getSession();

//        We begin a Transaction for our queries to be in wrapped
        Transaction transaction = session.beginTransaction();

//        We send our data to the DBMS from the pre-defined method called save through the session we created
        session.save(customer);

//        Then we commit the Transaction to send the data
        transaction.commit();

//        After all that we must close the session as it is not "Thread Safe"
        session.close();
    }
}