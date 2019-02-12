package job4j.carStrorage.logic;

import job4j.carStrorage.logic.items.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

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
        //list.add(user);
    }

    @Test
    public void add() {

    }

    @Test
    public void returnAll() {
        Assert.assertThat(list.returnAll(), is(list.returnAll()));
    }

    @Test
    public void returnById() {
        Assert.assertThat(user.getLogin(), is(list.returnById(4).getLogin()));
    }

    @Test
    public void returnByLogin() {
        Assert.assertThat(user.getLogin(), is(list.returnByLogin("test").getLogin()));
    }
}