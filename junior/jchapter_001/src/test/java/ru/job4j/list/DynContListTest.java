package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class DynContListTest {
    DynContList dcl;
    @Before
    public void setUp() {
        dcl = new DynContList();
        dcl.add(1);
        dcl.add(2);
        dcl.add(3);
        dcl.add(4);
        dcl.add(5);
        dcl.add(6);
        dcl.add(7);
        dcl.add(8);
        dcl.add(9);
        dcl.add(10);
    }

    @Test
    public void whenGrowArray() {
        assertThat(dcl.add(11), is(true));
    }

    @Test
    public void whenIterator() {
        assertThat(dcl.iterator().hasNext(), is(true));
        assertThat(dcl.iterator().next(), is(1));
    }
}
