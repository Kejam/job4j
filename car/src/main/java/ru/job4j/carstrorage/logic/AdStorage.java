package ru.job4j.carstrorage.logic;

import ru.job4j.carstrorage.logic.interfaces.StorageAd;
import ru.job4j.carstrorage.logic.items.Ad;
import ru.job4j.carstrorage.logic.items.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class AdStorage implements StorageAd, AutoCloseable {
    private final Wrapper wrapper = new Wrapper();
    private final static AdStorage INSTANCE = new AdStorage();
    private final UserStorage userStorage = UserStorage.getINSTANCE();
    private final CarStorage carStorage = CarStorage.getINSTANCE();
    private SessionFactory factory = new Configuration().configure().buildSessionFactory();

    public static AdStorage getINSTANCE() {
        return INSTANCE;
    }

    @Override
    public boolean add(Ad ad) {
        boolean result = false;
        wrapper.wrapperMethodT(session -> session.save(ad), factory);
        if (returnAll().contains(ad)) {
            result = true;
        }
        return result;
    }

    @Override
    public boolean update(Ad ad) {
        boolean result = false;
        wrapper.wrapperMethodVoid(session -> session.update(ad), factory);
        if (returnAll().contains(ad)) {
            result = true;
        }
        return result;
    }

    @Override
    public boolean remove(int id) {
        boolean result = false;
        Ad ad = new Ad();
        ad.setId(id);
        wrapper.wrapperMethodVoid(session -> session.remove(ad), factory);
        if (returnById(id) == null) {
            result = true;
        }
        return result;
    }

    @Override
    public List<Ad> returnAll() {
        return wrapper.wrapperMethodT(session -> session.createQuery("from Ad").list(), factory);
    }

    @Override
    public Ad returnById(int id) {
        return wrapper.wrapperMethodT(session -> session.get(Ad.class, id), factory);
    }

    @Override
    public void close() throws Exception {
        factory.close();
    }

    public User findUserByLogin(String login) {
        return userStorage.returnByLogin(login);
    }

    public boolean findByLogin(String login, String passowrd) {
        boolean result = false;
        for (User user: userStorage.returnAll()) {
            if (user.getLogin().equals(login) && user.getPassword().equals(passowrd)) {
                result = true;
                break;
            }
        }
        return result;
    }

}
