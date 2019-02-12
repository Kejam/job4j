package ru.job4j.carstrorage.logic.interfaces;

import ru.job4j.carstrorage.logic.items.User;
import java.util.List;

public interface StorageUser {
    boolean add(User user);
    List<User> returnAll();
    User returnById(int id);
}
