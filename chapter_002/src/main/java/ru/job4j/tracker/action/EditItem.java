package ru.job4j.tracker.action;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.UserAction;

public class EditItem implements UserAction {
    @Override
    public int key() {
        return 2;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Replace item --------------");
        String name = input.answer("Please, provide item name:");
        String desc = input.answer("Please, provide item description:");
        String id = input.answer("Please, provide item id");
        Item item = new Item(name, desc);
        tracker.replace(id, item);
        System.out.println("------------ Replace with Id : " + item.getId());
        System.out.println("------------ Replace with Name : " + item.getName());
        System.out.println("------------ Replace with Description : " + item.getDesc());
    }

    @Override
    public String info() {
        return "2. Replace Item.";
    }
}
