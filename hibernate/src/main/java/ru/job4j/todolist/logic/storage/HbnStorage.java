package ru.job4j.todolist.logic.storage;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.job4j.todolist.logic.model.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HbnStorage implements Storage, AutoCloseable {
    private static final HbnStorage INSTANCE = new HbnStorage();
    private final SessionFactory factory;
    private final Session session;

    public HbnStorage() {
        this.factory = new Configuration().configure().buildSessionFactory();
        this.session = factory.openSession();
    }

    public static Storage getInstance() {
        return INSTANCE;
    }


    @Override
    public boolean add(Item item) {
        boolean result = false;
        try  {
            session.beginTransaction();
            session.save(item);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean update(Item item) {
        boolean result = false;
        try  {
            session.beginTransaction();
            session.update(item);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean delete(int id) {
        boolean result = false;
        try  {
            session.beginTransaction();
            session.delete(id);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Item> readAll() {
        List<Item> result = new ArrayList<>();
        try  {
            session.beginTransaction();
            result = session.createSQLQuery("select * from clients").list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Item readById(int id) {
        List<Item> result = readAll();
        result.stream().filter(Item -> id==Item.getId()).collect(Collectors.toList());
        return result.get(0);
    }

    @Override
    public void close() throws Exception {
        session.close();
        factory.close();
    }
}
