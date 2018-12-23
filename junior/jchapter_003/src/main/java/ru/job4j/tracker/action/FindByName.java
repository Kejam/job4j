package ru.job4j.tracker.action;

import ru.job4j.tracker.BaseAction;
import ru.job4j.tracker.ITracker;
import ru.job4j.tracker.Input;
import ru.job4j.tracker.Item;

public class FindByName extends BaseAction {
    public FindByName(int key, String name) {
        super(key, name);
    }
    @Override
    public void execute(Input input, ITracker tracker) {
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
}
