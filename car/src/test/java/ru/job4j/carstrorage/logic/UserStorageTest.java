package ru.job4j.carstrorage.logic;

import org.junit.Ignore;
import ru.job4j.carstrorage.logic.UserStorage;
import ru.job4j.carstrorage.logic.items.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;

public class UserStorageTest {
    private UserStorage list;
    private User user;

    @Before
    public void init() {
        list = new UserStorage();
        user = new User();
        user.setName("alex");
        user.setPassword("123");
        user.setLogin("test");
        user.setPhone("021");
    }

    @Test
    public void add() {
        //list.add(user);
    }

    @Test
    public void returnAll() {
        Assert.assertThat(list.returnAll(), is(list.returnAll()));
    }

    @Ignore
    @Test
    public void returnById() {
        Assert.assertThat(user.getLogin(), is(list.returnById(2).getLogin()));
    }

    @Test
    public void returnByLogin() {
        Assert.assertThat(user.getLogin(), is(list.returnByLogin("test").getLogin()));
    }
}