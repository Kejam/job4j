package ru.job4j.learn;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table( name = "Emp" )
public class Emp {

    public Emp() {
    }

    @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        @Column(name="ID", nullable=false, unique=true, length=11)
        private int id;

        @Column(name="NAME", length=20, nullable=true)
        private String name;

        @Column(name="ROLE", length=20, nullable=true)
        private String role;

        @Column(name="insert_time", nullable=true)
        private Timestamp date;

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
    public void setDate(Timestamp insertTime) {
        this.date = insertTime;
    }

    public static void main(String[] args) {
        Emp1 emp = new Emp1();
        emp.setId(3);
        emp.setName("kate");
        emp.setRole("cto");
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
