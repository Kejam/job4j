package ru.job4j.servlets;

import ru.job4j.logic.User;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public interface Store {
    boolean add(User user);
    boolean update(int id, String name);
    boolean delete(int id);
    CopyOnWriteArrayList<User> findAll();
    User findById(int id);
}
