package ru.job4j.list;

import java.util.*;
import java.util.stream.Collectors;

public class UserSort {
    public Set<User> sort(List<User> list) {
        Set<User> userSet = list.stream().collect(Collectors.toSet());
        return userSet;
    }
    public List<User> sortNameLength(List<User> list) {
        List<User> sort = list.stream()
                .sorted((o1, o2) -> o1.getName().compareTo(o2.getName()))
                .collect(Collectors.toList());
        return sort;
    }
    public List<User> sortByAllFields(List<User> list) {
        List<User> sort = list.stream()
                .sorted(
                        Comparator.comparing(User::getName).thenComparingInt(User::getAge)
                )
                .collect(Collectors.toList());
        return sort;
    }
}
