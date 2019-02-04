package ru.job4j.todolist.logic.storage;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import ru.job4j.todolist.logic.model.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class HbnStorage implements Storage {
    private final SessionFactory factory = new Configuration().configure().buildSessionFactory();
    private static final HbnStorage INSTANCE = new HbnStorage();

    public static Storage getInstance() {
        return INSTANCE;
    }


    @Override
    public boolean add(Item item) {
        boolean result = false;
        this.tx(session -> session.save(item));
        if (readAll().contains(item)) {
            result = true;
        }
        return result;
    }

    @Override
    public boolean update(Item item) {
        boolean result = false;
        this.wrapperMethodVoid(session -> session.update(item));
        if (readAll().contains(item)) {
            result = true;
        }
        return result;
    }

    @Override
    public boolean delete(int id) {
        boolean result = true;
        this.wrapperMethodVoid(session -> session.delete(id));
        if (!readAll().contains(readById(id))) {
            result = true;
        }
        return result;
    }

    @Override
    public List<Item> readAll() {
        return this.tx(
                session -> session.createQuery("from items").list()
        );
    }

    @Override
    public Item readById(int id) {
        List<Item> result = readAll();
        result.stream().filter(Item -> id==Item.getId()).collect(Collectors.toList());
        return result.get(0);
    }

    private void wrapperMethodVoid(Consumer<Session> command) {
        Transaction transaction = null;
        try {Session session = factory.openSession()
            transaction = session.beginTransaction();
            command.accept(session);
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    private <T> T tx(final Function<Session, T> command) {
        final Session session = factory.openSession();
        final Transaction tx = session.beginTransaction();
        try {
            return command.apply(session);
        } catch (final Exception e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            tx.commit();
            session.close();
        }
    }
}
