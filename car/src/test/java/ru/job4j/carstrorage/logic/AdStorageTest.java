package ru.job4j.carstrorage.logic;

import org.junit.Ignore;
import ru.job4j.carstrorage.logic.AdStorage;
import ru.job4j.carstrorage.logic.UserStorage;
import ru.job4j.carstrorage.logic.items.Ad;
import ru.job4j.carstrorage.logic.items.Car;
import ru.job4j.carstrorage.logic.items.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;

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

    }

    @Test
    public void add() {
        //storage.add(ad);
    }

    @Ignore
    @Test
    public void update() {
        //ad.setDescription("update");
        storage.add(ad);
        ad.setDescription("up1");
        storage.update(ad);
        Assert.assertThat(storage.returnAll().contains(ad), is(true));
    }

    @Ignore
    @Test
    public void remove() {
        ad.setDescription("name");
//        storage.add(ad);
//        Assert.assertThat(storage.returnAll().contains(ad), is(true));
        storage.remove(8);
        Assert.assertThat(storage.returnAll().contains(ad), is(false));
    }

    @Ignore
    @Test
    public void returnAll() {
        Assert.assertThat(ad, is(storage.returnAll().contains(ad)));
    }

    @Test
    public void returnById() {
        Assert.assertThat(storage.returnById(8).getName(), is(ad.getName()));
    }
}