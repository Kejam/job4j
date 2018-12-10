package ru.job4j.generic;


import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleArrayTest {
    SimpleArray<Integer> simpleArray;
    @Before
    public void setUp() {
        simpleArray = new SimpleArray<>(10);
    }
    @Test
    public void whenAddThreeEl() {
        simpleArray.add(1);
        simpleArray.add(2);
        simpleArray.add(3);
        assertThat(simpleArray.get(1), is(2));
    }
    @Test
    public void whenAddThreeThenSetSecondEl() {
        simpleArray.add(1);
        simpleArray.add(2);
        simpleArray.add(3);
        simpleArray.set(1,10);
        assertThat(simpleArray.get(1), is(10));
    }
    @Test
    public void whenAddThreeThenDeleteSecondEl() {
        simpleArray.add(1);
        simpleArray.add(2);
        simpleArray.add(3);
        simpleArray.delete(1);
        assertThat(simpleArray.get(1), is(3));
    }
}
