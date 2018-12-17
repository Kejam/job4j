package ru.job4j.monitore;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class UserStorageTest {
    private class ThreadCount extends Thread {
        private final UserStorage userStorage;

        private ThreadCount(final UserStorage userStorage) {
            this.userStorage = userStorage;
        }

        @Override
        public void run() {
            this.userStorage.transfer(0, 1, 10);
        }
    }
    @Test
    public void whenTransferTwoThread() throws InterruptedException {
        final UserStorage userStorage = new UserStorage();
        userStorage.add(new User(0, 500));
        userStorage.add(new User(1, 500));
        Thread first = new ThreadCount(userStorage);
        Thread second = new ThreadCount(userStorage);
        first.start();
        second.start();
        first.join();
        second.join();
        assertThat(userStorage.get(1).getAmount(), is(520));
    }
}
