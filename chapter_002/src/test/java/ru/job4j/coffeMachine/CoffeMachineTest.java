package ru.job4j.coffeMachine;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CoffeMachineTest {
    @Test
    public void whenInput50() {
        CoffeMachine cm = new CoffeMachine();
        int[] actual = {10,5};
        assertThat(cm.changes(50, 35), is(actual));
    }
    @Test
    public void whenInput100() {
        CoffeMachine cm = new CoffeMachine();
        int[] actual = {10,10,10,10,10};
        assertThat(cm.changes(100, 50), is(actual));
    }
    @Test
    public void whenInput73() {
        CoffeMachine cm = new CoffeMachine();
        int[] actual = {10,10,10,5,2};
        assertThat(cm.changes(73, 36), is(actual));
    }
}
