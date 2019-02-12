package ru.job4j.carstrorage.logic;

import ru.job4j.carstrorage.logic.items.Ad;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Filters implements AutoCloseable {
    private SessionFactory factory = new Configuration().configure().buildSessionFactory();
    private final static Filters INSTANCE = new Filters();

    public static Filters getINSTANCE() {
        return INSTANCE;
    }

    public List<Ad> allTru() {
        return new Wrapper().wrapperMethodT(session -> session.createQuery("from adStorage where status = true").list(), factory);
    }

    public List<Ad> allWithPhoto() {
        return new Wrapper().wrapperMethodT(session -> session.createQuery("from adStorage where photo is not null ").list(), factory);
    }

    public List<Ad> lastDat(String nameCar) {
        String date = null;
        return null;
    }

    @Override public void close() throws Exception {
        factory.close();
    }

}
