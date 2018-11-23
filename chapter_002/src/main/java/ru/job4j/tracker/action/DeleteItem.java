package ru.job4j.tracker.action;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.UserAction;

public class DeleteItem implements UserAction {
    @Override
    public int key() {
        return 3;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Delete item --------------");
        String id = input.answer("Please, provide item id");
        boolean result = tracker.delete(id);
        if (result) {
            System.out.println("Item delete");
        } else {
            System.out.println("Not found item ");
        }
    }

    @Override
    public String info() {
        return "3. Delete Item.";
    }
}
