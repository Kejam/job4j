package ru.job4j.tracker.action;

import ru.job4j.tracker.BaseAction;
import ru.job4j.tracker.ITracker;
import ru.job4j.tracker.Input;
import ru.job4j.tracker.Item;

public class EditItem extends BaseAction {
    public EditItem(int key, String name) {
        super(key, name);
    }
    @Override
    public void execute(Input input, ITracker tracker) {
        String name = input.answer("Please, provide item name:");
        String desc = input.answer("Please, provide item description:");
        String id = input.answer("Please, provide item id:");
        tracker.replace(String.valueOf(id), new Item(id, name, desc));
    }

}
