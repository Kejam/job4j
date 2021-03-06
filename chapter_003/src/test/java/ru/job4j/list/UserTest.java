package ru.job4j.list;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserTest {
    @Test
    public void when2User() {
        List<User> list = List.of(
                new User("Alex", "45", "Moscow", 12),
                new User("Kate", "25", "Moscow", 123)
        );
        UserSort us = new UserSort();
        Set<User> actual = us.sort(list);
        List<User> expect = List.of(
                new User("Kate", "25", "Moscow", 123),
                new User("Alex", "45", "Moscow", 12)
        );
        assertThat(actual.toString(), is(expect.toString()));
    }
    @Test
    public void when2UserSortByLenghtName() {
        List<User> list = List.of(
                new User("Alex", "45", "Moscow", 1),
                new User("Katen", "25", "Moscow", 2),
                new User("Ivan", "23", "London", 3)
        );
        UserSort us = new UserSort();
        List<User> actual = us.sortNameLength(list);
        List<User> expect = List.of(
                new User("Alex", "45", "Moscow", 1),
                new User("Ivan", "23", "London", 3),
                new User("Katen", "25", "Moscow", 2)

        );
        assertThat(actual.toString(), is(expect.toString()));
    }
    @Test
    public void when2UserByAllFields() {
        List<User> list = List.of(
                new User("Alex", "45", "Moscow", 1),
                new User("Serg", "1", "Minsk", 2),
                new User("Ivan", "23", "London", 3),
                new User("Katen", "25", "Moscow", 4)
        );
        UserSort us = new UserSort();
        List<User> actual = us.sortByAllFields(list);
        List<User> expect = List.of(
                new User("Alex", "45", "Moscow", 1),
                new User("Ivan", "23", "London", 3),
                new User("Katen", "25", "Moscow", 4),
                new User("Serg", "1", "Minsk", 2)
        );
        assertThat(actual.toString(), is(expect.toString()));
    }
}
