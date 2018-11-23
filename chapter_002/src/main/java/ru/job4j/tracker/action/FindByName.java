package ru.job4j.tracker.action;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.UserAction;

public class FindByName implements UserAction {
    @Override
    public int key() {
        return 5;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Find item by name --------------");
        String name = input.answer("Please, provide item name:");
        Item[] items = tracker.findByName(name);
        if (items.length >= 0) {
            for (Item item: items) {
                System.out.println(item);
            }
        } else {
            System.out.println("Not found items by name " + name);
        }
    }

    @Override
    public String info() {
        return "5. Find item by id name.";
    }
}
