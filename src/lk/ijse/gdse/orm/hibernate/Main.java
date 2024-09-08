package lk.ijse.gdse.orm.hibernate;

import lk.ijse.gdse.orm.hibernate.config.SessionFactoryConfig;
import lk.ijse.gdse.orm.hibernate.embedded.MobileNumber;
import lk.ijse.gdse.orm.hibernate.embedded.NameIdentifier;
import lk.ijse.gdse.orm.hibernate.entity.Customer_1;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Customer_1 customer = new Customer_1();

        /*
        This is the way 01 of doing this task.But it is much easier to do it in way 02

        NameIdentifier name = new NameIdentifier();
        name.setFirstName("Kamal");
        name.setMiddleName("De");
        name.setLastName("Silva");
        customer.setNameIdentifier(name);
        */
        /*customer.setId(1);*/
//        customer.setName("Kamal");

//        This is the Way 02
        customer.setNameIdentifier(new NameIdentifier("Kamal","De","Silva"));
        customer.setAddress("Gall e");
        customer.setSalary(25000.00);


        List<MobileNumber> mobileNos = new ArrayList<>();

        MobileNumber homeNumber = new MobileNumber();
        homeNumber.setType("Home");
        homeNumber.setMobileNumber("0919948453");

        MobileNumber mobileNumber = new MobileNumber();
        mobileNumber.setType("Mobile");
        mobileNumber.setMobileNumber("0778849453");

        mobileNos.add(homeNumber);
        mobileNos.add(mobileNumber);

        customer.setPhoneNos(mobileNos);


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
//        customer.setName("Sunimal");
        customer.setNameIdentifier(new NameIdentifier("Kamal","De","Silva"));


        updateCusSession.update(customer);

        updateCusTransaction.commit();

        updateCusSession.close();



//        ============================ Data Retrieve ========================

//        In here we are going to  get data from the customer table from the DB


       Session getCusSession  = SessionFactoryConfig.getInstance().getSession();

        Customer_1 existingCustomer = getCusSession.get(Customer_1.class, 1);

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