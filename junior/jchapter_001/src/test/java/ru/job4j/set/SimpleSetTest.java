package ru.job4j.set;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleSetTest {
    SimpleSet<Integer> set;
    @Before
    public void setUp() {
        set = new SimpleSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);
        set.add(6);
        set.add(7);
        set.add(8);
        set.add(9);
        set.add(10);
    }
    @Test
    public void whenAdd11ElementThenGrowSet() {
        assertThat(set.add(11), is(true));
    }
    @Test
    public void whenAdd1RepeatElementThenFalse() {
        assertThat(set.add(10), is(false));
    }
}
