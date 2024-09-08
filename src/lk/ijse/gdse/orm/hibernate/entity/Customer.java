package lk.ijse.gdse.orm.hibernate.entity;

import lk.ijse.gdse.orm.hibernate.embedded.NameIdentifier;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity(name = "customer")
//@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int id;

    /*@Column(name = "customer_name")
    private String name;*/

    private NameIdentifier nameIdentifier;

    @Column(name = "customer_address")
    private String address;
    @Column(name = "customer_salary")
    private double salary;
    @Column(name = "customer_age",columnDefinition = "TINYINT")
    private int age;
    @CreationTimestamp
    @Column(name = "TimeAndDate")
    private Timestamp timestamp;
    @Transient
    @Column(name = "TransientOBJ")
    private String transientObj;

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", nameIdentifier=" + nameIdentifier +
                ", address='" + address + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                ", timestamp=" + timestamp +
                ", transientObj='" + transientObj + '\'' +
                '}';
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public NameIdentifier getNameIdentifier() {
        return nameIdentifier;
    }

    public void setNameIdentifier(NameIdentifier nameIdentifier) {
        this.nameIdentifier = nameIdentifier;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getTransientObj() {
        return transientObj;
    }

    public void setTransientObj(String transientObj) {
        this.transientObj = transientObj;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Customer(int id, NameIdentifier nameIdentifier, String address, double salary, int age, Timestamp timestamp, String transientObj) {
        this.id = id;
        this.nameIdentifier = nameIdentifier;
        this.address = address;
        this.salary = salary;
        this.age = age;
        this.timestamp = timestamp;
        this.transientObj = transientObj;
    }

    public Customer() {
    }
}
