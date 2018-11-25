package ru.job4j.tracker.action;

import ru.job4j.tracker.*;

public class EditItem extends BaseAction {
    public EditItem(int key, String name) {
        super(key, name);
    }
    @Override
    public void execute(Input input, Tracker tracker) {
        String name = input.answer("Please, provide item name:");
        String desc = input.answer("Please, provide item description:");
        String id = input.answer("Please, provide item id");
        tracker.replace(id, new Item(name, desc));

    }

}
