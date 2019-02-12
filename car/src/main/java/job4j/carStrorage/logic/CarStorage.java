package job4j.carStrorage.logic;

import job4j.carStrorage.logic.interfaces.StorageCar;
import job4j.carStrorage.logic.items.Car;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.stream.Collectors;

public class CarStorage implements StorageCar, AutoCloseable {
    private final static CarStorage INSTANCE = new CarStorage();
    private SessionFactory factory = new Configuration().configure().buildSessionFactory();

    public CarStorage() {
    }

    public static CarStorage getINSTANCE() {
        return INSTANCE;
    }

    @Override
    public boolean add(Car car) {
        boolean result = false;
        new Wrapper().wrapperMethodT(session -> session.save(car), factory);
        if (returnAll().contains(car)) {
            result = true;
        }
        return result;
    }

    @Override
    public List<Car> returnAll() {
        return new Wrapper().wrapperMethodT(session -> session.createQuery("from Car").list(), factory);
    }

    @Override
    public Car returnById(int id) {
        return returnAll().stream().filter(car -> car.getId().equals(id)).collect(Collectors.toList()).get(0);
    }

    @Override
    public void close() throws Exception {
        factory.close();
    }
}
