package ru.job4j.poll;

import javafx.concurrent.Worker;
import ru.job4j.wait.SimpleBlockingQueue;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadPool {
    private final List<Thread> threads;
    private final SimpleBlockingQueue<Runnable> tasks;
    private int size;

    public ThreadPool(int size) {
        this.size = Runtime.getRuntime().availableProcessors();
        this.threads = new LinkedList<>();
        this.tasks = new SimpleBlockingQueue<>(100);
        for (int i = 0; i < size; i++) {
            this.threads.add(new Worker(this.tasks));
        }
        this.threads.forEach(Thread::start);
    }

    public void work(Runnable job) throws InterruptedException {
        this.tasks.offer(job);
    }

    public void shutdown() throws InterruptedException {
        threads.forEach(Thread::interrupt);
    }

    private class Worker extends Thread {

        private final SimpleBlockingQueue<Runnable> tasks;

        private Worker(final SimpleBlockingQueue<Runnable> tasks) {
            this.tasks = tasks;
        }

        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    tasks.poll().run();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

}