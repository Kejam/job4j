package ru.job4j.tracker.action;

import ru.job4j.tracker.BaseAction;
import ru.job4j.tracker.ITracker;
import ru.job4j.tracker.Input;

public class DeleteItem extends BaseAction {
    public DeleteItem(int key, String name) {
        super(key, name);
    }
    public void execute(Input input, ITracker tracker) {
        System.out.println("------------ Delete item --------------");
        String id = input.answer("Please, provide item id:");
        tracker.delete(id);
    }
}
