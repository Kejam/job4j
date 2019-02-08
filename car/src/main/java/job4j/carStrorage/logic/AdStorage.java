package job4j.carStrorage.logic;

import job4j.carStrorage.logic.interfaces.StorageAd;
import job4j.carStrorage.logic.items.Ad;
import job4j.carStrorage.logic.items.Car;
import job4j.carStrorage.logic.items.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.transaction.UserTransaction;
import java.util.List;
import java.util.stream.Collectors;

public class AdStorage implements StorageAd, AutoCloseable {
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
        new Wrapper().wrapperMethodT(session -> session.save(ad), factory);
        if (returnAll().contains(ad)) {
            result = true;
        }
        return result;
    }

    @Override
    public boolean update(Ad ad) {
        boolean result = false;
        new Wrapper().wrapperMethodVoid(session -> session.update(ad), factory);
        if (returnAll().contains(ad)) {
            result = true;
        }
        return result;
    }

    @Override
    public boolean remove(int id) {
        boolean result = false;
        new Wrapper().wrapperMethodVoid(session -> session.remove(id), factory);
        if (returnById(id) == null) {
            result = true;
        }
        return result;
    }

    @Override
    public List<Ad> returnAll() {
        return new Wrapper().wrapperMethodT(session -> session.createQuery("from adStorage"), factory).list();
    }

    @Override
    public Ad returnById(int id) {
        return returnAll().stream().filter(ad -> ad.getId().equals(id)).collect(Collectors.toList()).get(0);
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

    public static void main(String[] args) {
        User user = new User();
        Car car = new Car();
        user.setName("sdfg");
        car.setName("bmw");
        new UserStorage().add(user);
        //new CarStorage().add(car);
//        Ad ad = new Ad();
//        ad.setCar(car);
//        ad.setUser(user);
//        ad.setDescription("bmw is okay");
        //new AdStorage().add(ad);
    }
}
