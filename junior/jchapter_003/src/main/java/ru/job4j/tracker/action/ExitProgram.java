package ru.job4j.tracker.action;

import ru.job4j.tracker.BaseAction;
import ru.job4j.tracker.ITracker;
import ru.job4j.tracker.Input;

public class ExitProgram extends BaseAction {
    public ExitProgram(int key, String name) {
        super(key, name);
    }
    @Override
    public void execute(Input input, ITracker tracker) {
        System.out.println("Press y");
    }
}
