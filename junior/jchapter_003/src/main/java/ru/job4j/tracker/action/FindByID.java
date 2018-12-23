package ru.job4j.tracker.action;

import ru.job4j.tracker.BaseAction;
import ru.job4j.tracker.ITracker;
import ru.job4j.tracker.Input;
import ru.job4j.tracker.Item;

public class FindByID extends BaseAction {
    public FindByID(int key, String name) {
        super(key, name);
    }
    @Override
    public void execute(Input input, ITracker tracker) {
        int id = Integer.valueOf(input.answer("Please, provide item id:"));
        Item item = tracker.findById(String.valueOf(id));
        if (item.equals(null)) {
            System.out.println("Not found item by id " + id);
        } else {
            System.out.println(item);
        }
    }

}
