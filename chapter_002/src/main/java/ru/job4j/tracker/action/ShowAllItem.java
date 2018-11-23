package ru.job4j.tracker.action;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.UserAction;

public class ShowAllItem implements UserAction {
    @Override
    public int key() {
        return 1;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Show all items --------------");
        Item[] items = tracker.findAll();
        if (items.length >= 0) {
            for (Item item: items) {
                System.out.println(item);
            }
        } else {
            System.out.println("Tracker hasn't got item. Please, add any item!");
        }
    }

    @Override
    public String info() {
        return "1. Show all Item.";
    }
}
