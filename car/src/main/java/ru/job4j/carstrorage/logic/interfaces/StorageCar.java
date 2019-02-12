package ru.job4j.carstrorage.logic.interfaces;

import ru.job4j.carstrorage.logic.items.Car;

import java.util.List;

public interface StorageCar {
    boolean add(Car car);
    List<Car> returnAll();
    Car returnById(int id);
}
