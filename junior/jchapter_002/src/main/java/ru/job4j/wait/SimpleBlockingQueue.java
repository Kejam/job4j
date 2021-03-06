package ru.job4j.wait;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.LinkedList;
import java.util.Queue;



@ThreadSafe
public class SimpleBlockingQueue<T> {
    private final int size;


    @GuardedBy("this")
    private Queue<T> queue = new LinkedList<>();

    public SimpleBlockingQueue(int size) {
        this.size = size;
    }

    public synchronized void offer(T value) throws InterruptedException {
        notify();
        while (queue.size() > size) {
            wait();
        }
        queue.offer(value);
    }



    public T poll() throws InterruptedException {
        notify();
        while (queue.isEmpty()) {
            wait();
        }
        T result = queue.poll();
        return result;
    }

    public int getSize() {
        return size;
    }
}
