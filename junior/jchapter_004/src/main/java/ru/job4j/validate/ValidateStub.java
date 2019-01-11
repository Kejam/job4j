package ru.job4j.validate;

import ru.job4j.logic.User;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public class ValidateStub implements Validate {
    private final Map<Integer, User> store = new HashMap<>();
    private int ids = 0;

    @Override
    public boolean add(User user) {
        boolean result = false;
        user.setId(ids++);
        store.put(user.getId(), user);
        if (store.containsValue(user)) {
            result = true;
        }
        return result;
    }

    @Override
    public boolean update(int id, User user) {
        boolean result = false;
        store.replace(id, user);
        if (store.containsValue(user)) {
            result = true;
        }
        return result;
    }

    @Override
    public boolean delete(int id) {
        boolean result = false;
        store.remove(id);
        if (!store.containsValue(id)) {
            result = true;
        }
        return result;
    }

    @Override
    public CopyOnWriteArrayList<User> findAll() {
        CopyOnWriteArrayList<User> list = null;
        for (Map.Entry<Integer, User> user: store.entrySet()) {
            list.add(user.getValue());
        }
        return list;
    }

    @Override
    public User findById(int id) {
        return store.get(id);
    }
}
