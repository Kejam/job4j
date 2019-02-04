package ru.job4j.todolist.validate;

import net.sf.ehcache.store.Store;
import ru.job4j.todolist.logic.model.Item;
import ru.job4j.todolist.logic.storage.HbnStorage;
import ru.job4j.todolist.logic.storage.Storage;

import java.util.List;

public class ValidateStorage implements Validate {
    private static final Validate INSTANCE = new ValidateStorage();
    private static Storage logic;

    public ValidateStorage() {
        logic =  HbnStorage.getInstance();
    }

    public static Validate getInstance() {
        return INSTANCE;
    }

    @Override
    public boolean add(Item item) {
        return logic.add(item);
    }

    @Override
    public boolean update(Item item) {
        boolean result = false;
        if(item.getId() > 0) {
            result = logic.update(item);
        }
        return result;
    }

    @Override
    public boolean delete(int id) {
        boolean result = false;
        if(id > 0) {
            result = logic.delete(id);
        }
        return result;
    }

    @Override
    public List<Item> readAll() {
        return logic.readAll();
    }

    @Override
    public Item readById(int id) {
        return logic.readById(id);
    }
}
