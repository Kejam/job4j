package ru.job4j.poll;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EmailNotification {
    private String subject;
    private String body;
    ExecutorService pool = Executors.newFixedThreadPool(
            Runtime.getRuntime().availableProcessors()
    );
    public void emailTo(User user) {
        Runnable runnable = () -> {
            String subject = String.format("Notification %s to email %s", user.username, user.email);
            String body = String.format("Add a new event to %s", user.username);
            send(subject, body, user.email);
        };
        pool.submit(runnable);
    }
    public void close() {
        pool.shutdown();
        while (!pool.isTerminated()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void send(String suject, String body, String email) {

    }
    class User {
        private String username;
        private String email;
    }
}
