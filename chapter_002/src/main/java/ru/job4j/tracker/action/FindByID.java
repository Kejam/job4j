package ru.job4j.tracker.action;

import ru.job4j.tracker.*;

public class FindByID extends BaseAction {
    public FindByID(int key, String name) {
        super(key, name);
    }
    @Override
    public void execute(Input input, Tracker tracker) {
        int id = Integer.valueOf(input.answer("Please, provide item id:"));
        Item item = tracker.findById(String.valueOf(id));
        if (item.equals(null)) {
            System.out.println("Not found item by id " + id);
        } else {
            System.out.println(item);
        }
    }

}
