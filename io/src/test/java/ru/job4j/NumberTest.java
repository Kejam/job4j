package ru.job4j;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class NumberTest {
    private Number number;

    @Before
    public void setUp() {
        number = new Number();
    }

    @Test
    public void whenNumberIsEven() {
        InputStream in = new ByteArrayInputStream(StandardCharsets.UTF_8.encode("12").array());
        assertThat(number.isNumber(in), is(true));
    }
    @Test
    public void whenNumberIsoOdd() {
        InputStream in = new ByteArrayInputStream(StandardCharsets.UTF_8.encode("11").array());
        assertThat(number.isNumber(in), is(false));
    }
    @Test
    public void whenCatchException() {
        InputStream in = new ByteArrayInputStream(StandardCharsets.UTF_8.encode("11").array());
        assertThat(number.isNumber(in), is(false));
    }
}
