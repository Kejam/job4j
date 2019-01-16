package ru.job4j.servlets;

import org.junit.Ignore;
import org.junit.Test;
import ru.job4j.logic.DBStore;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class TestDBSTORE {

    @Test
    public void whenFindAll() {
        DBStore store = new DBStore();
        assertThat(store.findAll(), is(store.findById(1)));
    }

    @Test
    public void whenIsCredential() {
        DBStore store = new DBStore();
        assertThat(store.isCredential("root", "root"), is(true));
    }

}
