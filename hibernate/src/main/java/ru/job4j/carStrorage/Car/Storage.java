package ru.job4j.carStrorage.Car;

public interface Storage {
    boolean add(String name, int engine, int carBody, int transmission);
    boolean update(int id, String name, int engine, int carBody, int transmission);
    boolean remove(Car car);
}
