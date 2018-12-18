package ru.job4j.wait;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.LinkedList;
import java.util.Queue;

@ThreadSafe
public class SimpleBlockingQueue<T> {

    private Object lock = new Object();
    private boolean consumer = true;
    private boolean producer = true;

    @GuardedBy("this")
    private Queue<T> queue = new LinkedList<>();

    public void offer(T value) throws InterruptedException {
        synchronized (this.lock) {
            while (this.producer) {
                lock.wait();
            }
            queue.add(value);
            consumer = false;
        }
    }



    public T poll() throws InterruptedException {
        Object result = null;
        synchronized (this.lock) {
            while (this.consumer) {
                lock.wait();
            }
            result = queue.poll();
            producer = false;
        }
        return (T) result;
    }
}
