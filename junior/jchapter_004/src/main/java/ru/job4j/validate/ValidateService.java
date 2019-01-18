package ru.job4j.validate;

import ru.job4j.logic.DBStore;
import ru.job4j.logic.Store;
import ru.job4j.logic.User;

import java.util.concurrent.CopyOnWriteArrayList;

public class ValidateService implements Validate {
    private static final Validate INSTANCE = new ValidateService();
    private static Store logic;
    private ValidateService() {
        logic = DBStore.getInstance();
    };
    public static Validate getInstance() {
        return INSTANCE;
    }
    public boolean add(User user) {
        return logic.add(user);
    }
    public boolean update(int id, User user) {
        if (logic.findById(id) == null) {
            new Exception("User not found");
        }
        return logic.update(id, user);
    }
    public boolean delete(int id) {
        return logic.delete(id);
    }
    public CopyOnWriteArrayList<User> findAll() {
        return logic.findAll();
    }
    public User findById(int id) {
        return (User) logic.findById(id);
    }

    @Override
    public boolean findByLogin(User user) {
        boolean result = false;
        User user1 = logic.findByLogin(user);
        if (user1 != null && user1.getPassword().equals(user.getPassword())) {
            result = true;
        }
        return result;
    }

    @Override
    public int role(User user) {
        return logic.role(user);
    }


}
