package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FacrotialTest {
    @Test
    public void whenFactrorialIsFiveThenHundreedTwo() {
        Factorial fac = new Factorial();
        int result = fac.add(5);
        assertThat(result, is(120));
    }

    @Test
    public void whenFactrorialIsZeroThenOne() {
        Factorial fac = new Factorial();
        int result = fac.add(0);
        assertThat(result, is(1));
    }
}
