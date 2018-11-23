package ru.job4j.tracker.action;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.UserAction;

public class FindByID implements UserAction {
    @Override
    public int key() {
        return 4;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Find item by id --------------");
        String id = input.answer("Please, provide item id:");
        Item item = tracker.findById(id);
        if (item.equals(null)) {
            System.out.println("Not found item by id " + id);
        } else {
            System.out.println(item);
        }
    }

    @Override
    public String info() {
        return "4. Find item by id item.";
    }
}
