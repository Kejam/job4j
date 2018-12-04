package ru.job4j.labmda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static java.lang.Math.log;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class DiaposonTest {
    @Test
    public void whenLinear() {
        Diapason diapason = new Diapason();
        List<Double> actual = diapason.diapason(1, 4, (d) ->  d);
        List<Double> expected = Arrays.asList(1d, 2d, 3d);
        assertThat(actual, is(expected));
    }
    @Test
    public void whenSquare() {
        Diapason diapason = new Diapason();
        List<Double> actual = diapason.diapason(1, 4, (d) -> Math.pow(d, d));
        List<Double> expected = Arrays.asList(1d, 4d, 27d);
        assertThat(actual, is(expected));
    }
    @Test
    public void whenLog() {
        Diapason diapason = new Diapason();
        List<Double> actual = diapason.diapason(1, 3, (d) -> Math.ceil(log(d)));
        List<Double> expected = Arrays.asList(0d, 1d);
        assertThat(actual, is(expected));
    }

}
