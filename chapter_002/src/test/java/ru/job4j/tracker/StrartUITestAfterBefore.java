package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Objects;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StrartUITestAfterBefore {
    private final Tracker tracker = new Tracker();
    private Item item;
    private Input input;
    @Before
    public void loadOutput() {
        System.out.println("execute before method");
        this.item = tracker.add(new Item("Alex", "desc"));
    }
    @After
    public void backOutput() {
        this.tracker.delete(item.getId());
        System.out.println("execute after method");
    }

    @Test
    public void whenUpdateAfterThen() {
        this.input = new StubInput(new String[]{"2", "Kate", "I can help you", item.getId(), "заменили заявку", "6"});
        new StartUI(this.input, this.tracker);
        assertThat(this.tracker.findById(this.item.getId()).getName(), is("Kate"));
    }



}
