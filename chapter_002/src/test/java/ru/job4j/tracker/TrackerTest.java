package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
       Tracker tracker = new Tracker();
       Item item = new Item("Alex", "Help me");
       tracker.add(item);
       List<Item> items = (Arrays.asList(item));
       assertThat(tracker.findAll(), is(items));
    }
    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item item = new Item("Alex", "Help me");
        Item item1 = new Item("Alex1", "Help me1");
        tracker.add(item);
        tracker.replace(item.getId(), item1);
        assertThat(tracker.findById(item.getId()), is(item1));

    }
    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("Alex", "Help me");
        tracker.add(item);
        tracker.delete(item.getId());
        List<Item> items = (Arrays.asList());
        assertThat(tracker.findAll(), is(items));
    }
    @Test
    public  void whenFindByName() {
        Tracker tracker = new Tracker();
        Item item = new Item("Alex", "Help me");
        tracker.add(item);
        assertThat(tracker.findById(item.getId()), is(item));
    }
}
