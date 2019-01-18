package ru.job4j.validate;

import ru.job4j.logic.User;

import java.util.concurrent.CopyOnWriteArrayList;

public interface Validate {
    boolean add(User user);
    boolean update(int id, User user);
    boolean delete(int id);
    CopyOnWriteArrayList<User> findAll();
    User findById(int id);
    boolean findByLogin(User user);
    int role(User user);
}
