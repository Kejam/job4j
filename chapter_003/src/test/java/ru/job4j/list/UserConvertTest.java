package ru.job4j.list;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserConvertTest {
    @Test
    public void when() {
        UserConvert use = new UserConvert();
        List<User> list = (Arrays.asList(
                new User("Alex", "45", "Moscow", 1),
                new User("Katen", "25", "Moscow", 2),
                new User("Ivan", "23", "London", 3)
        ));
        Map result = use.process(list);
        Set<String> result1 = result.keySet();
        ArrayList<String> expect = new ArrayList<>();
        expect.add("23");
        expect.add("45");
        expect.add("25");
        assertThat(result1.toString(), is(expect.toString()));
    }
}
