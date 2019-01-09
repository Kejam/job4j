package ru.job4j.servlets;

import ru.job4j.logic.User;

import java.util.concurrent.CopyOnWriteArrayList;

public interface Validate<User> {
    boolean add(User user);
    boolean update(int id, User user);
    boolean delete(int id);
    CopyOnWriteArrayList<User> findAll();
    User findById(int id);
}
