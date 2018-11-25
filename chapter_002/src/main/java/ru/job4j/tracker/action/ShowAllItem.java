package ru.job4j.tracker.action;

import ru.job4j.tracker.*;

public class ShowAllItem extends BaseAction {
    public ShowAllItem(int key, String name) {
        super(key, name);
    }
    @Override
    public void execute(Input input, Tracker tracker) {
        Item[] items = tracker.findAll();
        if (items.length >= 0) {
            for (Item item: items) {
                System.out.println(item);
            }
        } else {
            System.out.println("Tracker hasn't got item. Please, add any item!");
        }
    }

}
