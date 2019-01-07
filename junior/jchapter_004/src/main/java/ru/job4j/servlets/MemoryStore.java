package ru.job4j.servlets;

import ru.job4j.logic.User;

import java.util.Random;
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
        user.setId(generateID());
        list.add(user);
        if (list.contains(user)) {
            result = true;
        }
        return result;
    }

    @Override
    public boolean update(int id, String name) {
        boolean result = false;
        list.get(id).setName(name);
        if (list.get(id).equals(name)) {
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
        User user = null;
        for(User user1: list) {
            if (user1.getId() == id) {
                user = user1;
            }
        }
        return user;
    }

    private int generateID() {
        Random random = new Random();
        int id = 1;
        while (checkID(id)) {
            id = random.nextInt(10000);
        }
        return id;
    }

    private boolean checkID(int ID) {
        boolean result = false;
        for (User user: list) {
            if (user.getId() == ID) {
                result = true;
            }
        }
        return result;
    }
}
