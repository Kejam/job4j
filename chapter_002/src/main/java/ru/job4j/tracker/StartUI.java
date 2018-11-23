package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

/** @author Aleksey Prozorov (kejamwork@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class StartUI  {
    private final Input input;
    private final Tracker tracker;
    private int[] rangeValue = {0,1,2,3,4,5,6};
    /**
     * Default constructor.
     * @param input
     * @param tracker
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }
    /**
     *  Init in app.
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        List<Integer> range = new ArrayList<>();
        menu.fillActions();
        for (int i = 0; i < menu.getActionsLentgh(); i++) {
            range.add(i);
        }
        do {
            menu.show();
            menu.select(input.answer("Answer:", rangeValue));
        } while (!"y".equals(this.input.answer("Exit?(y): ")));
    }
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}