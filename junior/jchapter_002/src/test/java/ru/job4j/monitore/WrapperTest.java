package ru.job4j.monitore;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class WrapperTest {
    private class ThreadCount extends Thread {
        private final Wrapper<User> wrapper;

        private ThreadCount(Wrapper<User> wrapper) {
            this.wrapper = wrapper;
        }


        @Override
        public void run() {
            this.wrapper.add(new User(0,123));
        }
    }
    @Test
    public void whenTransferTwoThread() throws InterruptedException {
        final Wrapper<User> wrapper = new Wrapper<User>();

        Thread first = new ThreadCount(wrapper);
        Thread second = new ThreadCount(wrapper);
        first.start();
        second.start();
        first.join();
        second.join();
        assertThat(wrapper.getSize(), is(2));
    }
}
