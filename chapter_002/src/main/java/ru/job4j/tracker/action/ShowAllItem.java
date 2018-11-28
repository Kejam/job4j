package ru.job4j.tracker.action;

import ru.job4j.tracker.*;

import java.util.List;

public class ShowAllItem extends BaseAction {
    public ShowAllItem(int key, String name) {
        super(key, name);
    }
    @Override
    public void execute(Input input, Tracker tracker) {
        List<Item> items = tracker.findAll();
        if (items.size() >= 0) {
            for (Item item: items) {
                System.out.println(item);
            }
        } else {
            System.out.println("Tracker hasn't got item. Please, add any item!");
        }
    }

}
