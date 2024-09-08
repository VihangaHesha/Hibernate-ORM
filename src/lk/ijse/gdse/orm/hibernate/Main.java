package lk.ijse.gdse.orm.hibernate;

import lk.ijse.gdse.orm.hibernate.config.SessionFactoryConfig;
import lk.ijse.gdse.orm.hibernate.entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.dialect.DB2Dialect;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer();
        /*customer.setId(1);*/
        customer.setName("Kamal");
        customer.setAddress("Gall e");
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


//        ============================ Update ========================

//        In here we update customer details as we inserted in above code!


        Session updateCusSession = SessionFactoryConfig.getInstance().getSession();

        Transaction updateCusTransaction = updateCusSession.beginTransaction();
        customer.setAddress("Baddegama");
        customer.setSalary(6000.00);
        customer.setName("Sunimal");

        updateCusSession.update(customer);

        updateCusTransaction.commit();

        updateCusSession.close();



//        ============================ Data Retrieve ========================

//        In here we are going to  get data from the customer table from the DB


       Session getCusSession  = SessionFactoryConfig.getInstance().getSession();

        Customer existingCustomer = getCusSession.get(Customer.class, 1);

        System.out.println(existingCustomer);


//        ============================ Data Deletion ========================

//        In here we are going to  delete data from the customer table from the DB


       /* Session deleteCusSession = SessionFactoryConfig.getInstance().getSession();
        Transaction deleteCusTransaction = deleteCusSession.beginTransaction();

        deleteCusSession.delete(customer);

        deleteCusTransaction.commit();

        deleteCusSession.close();*/

    }
}