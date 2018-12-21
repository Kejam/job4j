package ru.job4j.nba;

import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicReference;

import static org.hamcrest.core.Is.is;

public class BaseStorageTest {
    @Test
    public void whenThrowException() throws InterruptedException {
        AtomicReference<Exception> ex = new AtomicReference<>();
        Thread thread = new Thread(
                () -> {
                    try {
                        throw new RuntimeException("Throw Exception in Thread");
                    } catch (Exception e) {
                        ex.set(e);
                    }
                }
        );
        thread.start();
        thread.join();
        Assert.assertThat(ex.get().getMessage(), is("Throw Exception in Thread"));
    }

    @Test
    public void whenUpdate() {
        BaseStorage cache = new BaseStorage();
        cache.add(new Base(1, 1));
        cache.add(new Base(2, 1));
        cache.add(new Base(3, 1));
        cache.update(new Base(2, 1));
        cache.update(new Base(1, 1));
    }

    @Test (expected = OptimisticException.class)
    public void whenTrowOptimisticException() {
        BaseStorage cache = new BaseStorage();
        cache.add(new Base(1, 1));
        cache.update(new Base(1, 1));
        cache.update(new Base(1, 1));
    }


}
