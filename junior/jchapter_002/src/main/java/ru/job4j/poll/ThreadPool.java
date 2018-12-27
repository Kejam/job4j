package ru.job4j.poll;

import ru.job4j.wait.SimpleBlockingQueue;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadPool {
    private final List<Thread> threads = new LinkedList<>();
    private final SimpleBlockingQueue<Runnable> tasks = new SimpleBlockingQueue<>(10);
    private int size = Runtime.getRuntime().availableProcessors();

    public void work(Runnable job) throws InterruptedException {
        if(tasks.getSize() < 1) {
            job.wait();
        }
        tasks.offer(job);
    }

    public void shutdown() throws InterruptedException {

    }

}