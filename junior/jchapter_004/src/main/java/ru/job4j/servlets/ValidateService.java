package ru.job4j.servlets;

import org.apache.commons.lang.Validate;
import ru.job4j.logic.User;

import java.util.concurrent.CopyOnWriteArrayList;

public class ValidateService extends Validate {
    private static ValidateService instance = new ValidateService();
    private static Store logic;
    private ValidateService() {
        logic = MemoryStore.getInstance();
    };
    public static ValidateService getInstance() {
        return instance;
    }
    public boolean add(User user) {
        return logic.add(user);
    }
    public boolean update(int id, String name) {
        return  logic.update(id, name);
    }
    public boolean delete(int id) {
        return logic.delete(id);
    }
    public CopyOnWriteArrayList<User> findAll() {
        return logic.findAll();
    }
    public User findById(int id) {
        return logic.findById(id);
    }
}
