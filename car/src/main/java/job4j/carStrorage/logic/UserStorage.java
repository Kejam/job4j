package job4j.carStrorage.logic;

import job4j.carStrorage.logic.interfaces.StorageUser;
import job4j.carStrorage.logic.items.Car;
import job4j.carStrorage.logic.items.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.stream.Collectors;

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
        return wrapper.wrapperMethodT(session -> session.createQuery("from userStorage"), factory).list();
    }

    @Override
    public User returnById(int id) {
        return returnAll().stream().filter(user -> user.getId().equals(id)).collect(Collectors.toList()).get(0);
    }

    @Override
    public void close() throws Exception {
        factory.close();
    }

    public User returnByLogin(String login) {
        return returnAll().stream().filter(user -> user.getLogin().equals(login)).collect(Collectors.toList()).get(0);
    }

}
