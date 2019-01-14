package ru.job4j.validate;

import org.apache.commons.lang.Validate;
import ru.job4j.logic.DBStore;
import ru.job4j.logic.Store;
import ru.job4j.logic.User;

import java.util.concurrent.CopyOnWriteArrayList;

public class ValidateService extends Validate {
    private static final ValidateService instance = new ValidateService();
    private static Store logic;
    private ValidateService() {
        logic = DBStore.getInstance();
    };
    public static ValidateService getInstance() {
        return instance;
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
}
