package ru.job4j.wait;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimpleBlockingQueueTest {
    @Test
    public void when() throws InterruptedException {
        SimpleBlockingQueue<Integer> queue = new SimpleBlockingQueue<>();
        Thread a = new Thread() {
            @Override
            public void run() {
                try {
                    queue.offer(123);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread b = new Thread() {
            @Override
            public void run() {
                try {
                    System.out.println(queue.poll());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        a.start();
        b.start();
        a.join();
        b.join();
        assertThat(queue, is(queue));
    }
}
