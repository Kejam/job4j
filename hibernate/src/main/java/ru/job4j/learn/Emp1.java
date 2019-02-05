package ru.job4j.learn;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Timestamp;

public class Emp1 {
    private int id;
    private String name;
    private String role;
    private Timestamp date;

    public Emp1() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public static void main(String[] args) {
        Emp1 emp = new Emp1();
        emp.setId(1);
        emp.setName("alex");
        emp.setRole("asdf");
        emp.setDate(new Timestamp(System.currentTimeMillis()));

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        session.update(emp);
        session.getTransaction().commit();

        session.close();
        factory.close();
    }
}
