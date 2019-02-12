package ru.job4j.carstrorage.logic;


import ru.job4j.carstrorage.logic.CarStorage;
import ru.job4j.carstrorage.logic.items.Car;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;

public class CarStorageTestW {
    private CarStorage storage;
    private Car car;

    @Before
    public void init() {
        storage = new CarStorage();
        car = new Car();
    }

    @Test
    public void whenAdd() {
        car.setName("bmw");
        car.setColor("black");
        Car expect = car;

        storage.add(car);

        Assert.assertThat(storage.returnAll().contains(car), is(true));
    }


    @Test
    public void returnAll() {
        car.setName("bmw");
        car.setColor("black");
        Car one = car;
        Car two = car;
        List<Car> list = Arrays.asList(one, two);

        storage.add(car);
        storage.add(car);

        Assert.assertThat(storage.returnAll().contains(car), is(true));
    }

}