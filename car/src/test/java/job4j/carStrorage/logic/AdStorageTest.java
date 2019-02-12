package job4j.carStrorage.logic;

import job4j.carStrorage.logic.items.Ad;
import job4j.carStrorage.logic.items.Car;
import job4j.carStrorage.logic.items.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class AdStorageTest {
    private AdStorage storage;
    private Ad ad;

    @Before
    public void init() {
        storage = new AdStorage();
        User user = new UserStorage().returnByLogin("root");
        Car car = new Car();
        car.setName("bmw");
        car.setColor("white");
        ad = new Ad();
        ad.setUser(user);
        ad.setCar(car);
        ad.setName("Buy bmw");
        storage.add(ad);
    }

    @Test
    public void add() {

    }

    @Test
    public void update() {

    }

    @Test
    public void remove() {

    }

    @Test
    public void returnAll() {
        Assert.assertThat(ad, is(storage.returnAll()));
    }

    @Test
    public void returnById() {
        
    }
}