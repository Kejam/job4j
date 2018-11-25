package ru.job4j.tracker.action;

import ru.job4j.tracker.*;

public class AddItem extends BaseAction {
    public AddItem(int key, String name) {
        super(key, name);
    }
    @Override
    public void execute(Input input, Tracker tracker) {
        String name = input.answer("Please, provide item name:");
        String desc = input.answer("Please, provide item description:");
        tracker.add(new Item(name, desc));
    }
}
