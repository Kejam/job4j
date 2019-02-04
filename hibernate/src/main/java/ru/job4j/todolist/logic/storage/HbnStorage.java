package ru.job4j.todolist.logic.storage;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import ru.job4j.todolist.logic.model.Item;

import java.util.List;

public class HbnStorage implements Storage, AutoCloseable {
    private static final HbnStorage INSTANCE = new HbnStorage();
    private final SessionFactory factory;
    private final Session session;

    public HbnStorage() {
        this.factory = new Configuration().configure().buildSessionFactory();
        this.session = factory.openSession();
    }

    public static HbnStorage getInstance() {
        return INSTANCE;
    }


    @Override
    public boolean add(Item item) {
        try () {
            session.beginTransaction();
            session.save(item);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean update(Item item) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public List<Item> readAll() {
        return null;
    }

    @Override
    public Item readById() {
        return null;
    }

    @Override
    public void close() throws Exception {
        session.close();
        factory.close();
    }
}
