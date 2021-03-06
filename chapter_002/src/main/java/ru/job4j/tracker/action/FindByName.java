package ru.job4j.tracker.action;

import ru.job4j.tracker.*;

import java.util.List;

public class FindByName extends BaseAction {
    public FindByName(int key, String name) {
        super(key, name);
    }
    @Override
    public void execute(Input input, Tracker tracker) {
        String name = input.answer("Please, provide item name:");
        List<Item> items = tracker.findByName(name);
        if (items.size() >= 0) {
            for (Item item: items) {
                System.out.println(item);
            }
        } else {
            System.out.println("Not found items by name " + name);
        }
    }
}
