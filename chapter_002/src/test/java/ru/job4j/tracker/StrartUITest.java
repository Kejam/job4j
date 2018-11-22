package ru.job4j.tracker;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.collection.IsArrayContainingInAnyOrder.arrayContainingInAnyOrder;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class StrartUITest {
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();     // создаём Tracker
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker).init();     //   создаём StartUI и вызываем метод init()
        assertThat(tracker.findAll()[0].getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }
    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item("test name", "desc", System.currentTimeMillis()));
        //создаём StubInput с последовательностью действий(производим замену заявки)
        Input input = new StubInput(new String[]{"2", "test replace", item.getDesc(), item.getId(), "заменили заявку", "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }
    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("alex", "help me", System.currentTimeMillis()));
        tracker.delete(item.getId());
        String[] expect = {};
        assertThat(tracker.findAll(), is(expect));
    }
    @Test
    public void whenFindByIdItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("alex", "help me", System.currentTimeMillis()));
        Item actual = tracker.findById(item.getId());
        assertThat(actual, is(item));
    }
    @Test
    public void whenFindByNameItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("alex", "help me", System.currentTimeMillis()));
        Item[] actual = tracker.findByName(item.getName());
        assertThat(actual, arrayContainingInAnyOrder(item));
    }

}
