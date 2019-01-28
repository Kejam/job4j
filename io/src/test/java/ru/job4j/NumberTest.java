package ru.job4j;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.io.*;
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

    @Ignore
    @Test
    public void whenInputDropAbuses() {
        InputStream in = new ByteArrayInputStream(StandardCharsets.UTF_8.encode("11 22 33 33 33 22 33 14").array());
        OutputStream out = new ByteArrayOutputStream(1000);
        String[] abuses = {"22", "14"};
        String result = number.dropAbuses(in, out, abuses).toString();
        assertThat(result, is("11 33 33 33 33"));
    }

}
