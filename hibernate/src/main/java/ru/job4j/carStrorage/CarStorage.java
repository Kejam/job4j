package ru.job4j.carStrorage;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import ru.job4j.carStrorage.Car.*;


import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CarStorage implements Storage {
    private final SessionFactory factory = new Configuration().configure().buildSessionFactory();

    @Override
    public boolean add(String name, int engine, int carBody, int transmission) {
        boolean result = true;
        final Session session = factory.openSession();
        final Transaction tx = session.beginTransaction();
        try {
            Car car = new Car();
            car.setName(name);
            car.setCarBody(new CarBody(carBody));
            car.setEngine(new Engine(engine));
            car.setTransmission(new Transmission(transmission));
            session.save(car);
        } catch (Exception e){
            session.getTransaction().rollback();
            throw e;
        }finally {
            tx.commit();
            session.close();
        }
        return result;
    }

    @Override
    public boolean update(int id, String name, int engine, int carBody, int transmission) {
        boolean result = true;
        final Session session = factory.openSession();
        final Transaction tx = session.beginTransaction();
        try {
            Car car = new Car();
            car.setId(id);
            car.setName(name);
            car.setCarBody(new CarBody(carBody));
            car.setEngine(new Engine(engine));
            car.setTransmission(new Transmission(transmission));
            session.update(car);
        } catch (Exception e){
            session.getTransaction().rollback();
            throw e;
        }finally {
            tx.commit();
            session.close();
        }
        return result;
    }

    @Override
    public boolean remove(Car car) {
        boolean result = false;
        this.wrapperMethodVoid(
                session -> session.remove(car)
        );
        if (!returnAll().contains(readById(car.getId()))) {
            result = true;
        }
        return result;
    }

    public List<Car> returnAll() {
        return this.wrapperMethodT(
                session -> session.createQuery("from car").list()
        );
    }

    public Car readById(int id) {
        List<Car> result = returnAll();
        result.stream().filter(Car -> id==Car.getId()).collect(Collectors.toList());
        return result.get(0);
    }

    private void wrapperMethodVoid(Consumer<Session> command) {
        Transaction transaction = null;
        try {Session session = factory.openSession();
            transaction = session.beginTransaction();
            command.accept(session);
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    private <T> T wrapperMethodT(final Function<Session, T> command) {
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
