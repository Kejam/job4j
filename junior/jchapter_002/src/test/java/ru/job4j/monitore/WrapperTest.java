package ru.job4j.monitore;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class WrapperTest {
    @Test
    public void whenTransferTwoThread() throws InterruptedException {
        final Wrapper<User> wrapper = new Wrapper<User>();

        Runnable runnable = () -> {
            wrapper.add(new User(1,2));
        };
        Thread t = new Thread(runnable);
        Thread a = new Thread(runnable);
        a.start();
        t.start();
        a.join();
        a.join();
        assertThat(wrapper.getSize(), is(2));
    }
}
