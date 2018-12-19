package ru.job4j.monitore;

import org.junit.Test;

import java.util.ConcurrentModificationException;

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
        Thread b = new Thread() {
            @Override
            public void run() {
                try {
                    wrapper.iterator().next();
                } catch (ConcurrentModificationException e) {
                    e.printStackTrace();
                }
            }
        };
        b.start();
        t.start();
        b.join();
        t.join();
        assertThat(wrapper.getSize(), is(1));
    }
}
