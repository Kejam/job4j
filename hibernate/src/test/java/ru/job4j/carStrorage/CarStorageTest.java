package ru.job4j.carStrorage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.job4j.carStrorage.Car.Car;

import static org.hamcrest.Matchers.is;

public class CarStorageTest {
    private CarStorage storage;

    @Before
    public void init() {
        storage = new CarStorage();
    }

    @Test
    public void whenAddCar() {
        boolean expect = false;
        storage.add("bmw", 1,1,1);

        for (Car car: storage.returnAll()) {
            if (car.getName().equals("bmw")) {
                expect = true;
                break;
            }
        }

        Assert.assertThat(expect, is(true));
    }

    @Test
    public void whenUpdateCar() {
        boolean expect = false;
        storage.add("bmw", 1,1,1);
        storage.update(1, "audi", 1,1,1);

        for (Car car: storage.returnAll()) {
            if (car.getName().equals("audi")) {
                expect = true;
                break;
            }
        }

        Assert.assertThat(expect, is(true));
    }

    @Test
    public void whenDeleteCar() {
        boolean expect = false;
        storage.add("bmw", 1,1,1);

        for (Car car: storage.returnAll()) {
            if (car.getName().equals("bmw")) {
                expect = true;
                break;
            }
        }

        Assert.assertThat(expect, is(false));
    }
}