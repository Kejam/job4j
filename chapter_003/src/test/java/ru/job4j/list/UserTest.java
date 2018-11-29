package ru.job4j.list;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserTest {
    @Test
    public void when2User() {
        List<User> list = (Arrays.asList(
                new User("Alex", "45", "Moscow"),
                new User("Kate", "25", "Moscow")
        ));
        UserSort us = new UserSort();
        Set<User> actual = us.sort(list);
        List<User> expect = (Arrays.asList(
                new User("Kate", "25", "Moscow"),
                new User("Alex", "45", "Moscow")
        ));
        assertThat(actual.toString(), is(expect.toString()));
    }
    @Test
    public void when2UserSortByLenghtName() {
        List<User> list = (Arrays.asList(
                new User("Alex", "45", "Moscow"),
                new User("Katen", "25", "Moscow"),
                new User("Ivan", "23", "London")
        ));
        UserSort us = new UserSort();
        List<User> actual = us.sortNameLength(list);
        List<User> expect = (Arrays.asList(
                new User("Alex", "45", "Moscow"),
                new User("Ivan", "23", "London"),
                new User("Katen", "25", "Moscow")
        ));
        assertThat(actual.toString(), is(expect.toString()));
    }
    @Test
    public void when2UserByAllFields() {
        List<User> list = (Arrays.asList(
                new User("Alex", "45", "Moscow"),
                new User("Serg", "1", "Minsk"),
                new User("Ivan", "23", "London"),
                new User("Katen", "25", "Moscow")
        ));
        UserSort us = new UserSort();
        List<User> actual = us.sortNameLength(list);
        List<User> expect = (Arrays.asList(
                new User("Alex", "45", "Moscow"),
                new User("Ivan", "23", "London"),
                new User("Katen", "25", "Moscow"),
                new User("Serg", "1", "Minsk")
        ));
        assertThat(actual.toString(), is(expect.toString()));
    }
}
