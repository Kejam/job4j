package ru.job4j.wait;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.LinkedList;
import java.util.Queue;

@ThreadSafe
public class SimpleBlockingQueue<T> {


    @GuardedBy("this")
    private Queue<T> queue = new LinkedList<>();

    public synchronized void offer(T value) throws InterruptedException {
        while (queue.isEmpty()) {
            queue.offer(value);
        }
    }



    public T poll() throws InterruptedException {
        Object result = null;
        while (!queue.isEmpty()) {
            result = queue.poll();
        }
        return (T) result;
    }
}
