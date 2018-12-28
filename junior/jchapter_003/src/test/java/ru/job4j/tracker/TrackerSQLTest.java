package ru.job4j.tracker;

import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;

public class TrackerSQLTest {
    @Test
    public void checkConnection() {
        TrackerSQL sql = new TrackerSQL();
        assertThat(sql.init(), is(true));
    }
    @Test
    public void whenAddInTracker() {
        TrackerSQL sql = new TrackerSQL();
        sql.init();
        Item item = new Item("Alex", "Can help you?");
        sql.add(item);
        assertThat(sql.findById("5").getName(), is(item.getName()));
    }
}