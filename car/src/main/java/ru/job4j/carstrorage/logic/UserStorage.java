package ru.job4j.carstrorage.logic;

import ru.job4j.carstrorage.logic.interfaces.StorageUser;
import ru.job4j.carstrorage.logic.items.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class UserStorage implements StorageUser, AutoCloseable {
    private final static UserStorage INSTANCE = new UserStorage();
    private SessionFactory factory = new Configuration().configure().buildSessionFactory();
    private final Wrapper wrapper = new Wrapper();

    public static UserStorage getINSTANCE() {
        return INSTANCE;
    }

    @Override
    public boolean add(User user) {
        boolean result = false;
        wrapper.wrapperMethodT(session -> session.save(user), factory);
        if (returnAll().contains(user)) {
            result = true;
        }
        return result;
    }

    @Override
    public List<User> returnAll() {
        return wrapper.wrapperMethodT(session -> session.createQuery("from User").list(), factory);
    }

    @Override
    public User returnById(int id) {
        return wrapper.wrapperMethodT(session -> session.get(User.class, id), factory);
    }

    public User returnByLogin(String login) {
        User user = new User();
        for (User s: returnAll()) {
            if (s.getLogin().equals(login)) {
                user = s;
                break;
            }
        }
        return user;
    }

    @Override
    public void close() throws Exception {
        factory.close();
    }



}
