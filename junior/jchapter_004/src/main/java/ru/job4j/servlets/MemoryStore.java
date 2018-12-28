package ru.job4j.servlets;

import ru.job4j.logic.User;

import java.util.concurrent.CopyOnWriteArrayList;

public class MemoryStore implements Store {
    private static  MemoryStore instance;

    private CopyOnWriteArrayList<User> list;

    private MemoryStore() {
        list = new CopyOnWriteArrayList<>();
    }

    public static synchronized MemoryStore getInstance() {
        if (instance == null) {
            instance = new MemoryStore();
        }
        return instance;
    }


    @Override
    public boolean add(User user) {
        boolean result = false;
        list.add(user);
        if (list.contains(user)) {
            result = true;
        }
        return result;
    }

    @Override
    public boolean update(User user, int id) {
        boolean result = false;
        list.set(id, user);
        if (list.contains(user)) {
            result = true;
        }
        return result;
    }

    @Override
    public boolean delete(int id) {
        boolean result = false;
        list.remove(id);
        if (!list.contains(list.get(id))) {
            result = true;
        }
        return result;
    }

    @Override
    public CopyOnWriteArrayList<User> findAll() {
        CopyOnWriteArrayList<User> copy = new CopyOnWriteArrayList<>();
        for (User user: list) {
            copy.add(user);
        }
        return copy;
    }

    @Override
    public User findById(int id) {
        User user = list.get(id);
        return user;
    }
}
