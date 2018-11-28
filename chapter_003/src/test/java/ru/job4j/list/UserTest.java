package ru.job4j.list;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserTest {
    @Test
    public void when2UserSort() {
        List<User> list = (Arrays.asList(
                new User("Alex", "45"),
                new User("Kate", "25")
        ));
        UserSort us = new UserSort();
        Set<User> actual = us.sort(list);
        List<User> expect = (Arrays.asList(
                new User("Kate", "25"),
                new User("Alex", "45")
        ));
        assertThat(actual.toString(), is(expect.toString()));
    }
}
