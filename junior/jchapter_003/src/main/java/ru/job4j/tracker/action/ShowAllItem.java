package ru.job4j.tracker.action;

import ru.job4j.tracker.BaseAction;
import ru.job4j.tracker.ITracker;
import ru.job4j.tracker.Input;
import ru.job4j.tracker.Item;

public class ShowAllItem extends BaseAction {
    public ShowAllItem(int key, String name) {
        super(key, name);
    }
    @Override
    public void execute(Input input, ITracker tracker) {
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
