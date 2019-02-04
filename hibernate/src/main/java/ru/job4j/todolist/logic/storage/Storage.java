package ru.job4j.todolist.logic.storage;

import ru.job4j.todolist.logic.model.Item;

import java.util.List;

public interface Storage {
    boolean add(Item item);
    boolean update(Item item);
    boolean delete(int id);
    List<Item> readAll();
    Item readById();
}
