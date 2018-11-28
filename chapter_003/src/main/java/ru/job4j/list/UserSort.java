package ru.job4j.list;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class UserSort {
    public Set<User> sort(List<User> list) {
        Set<User> sort = new TreeSet<User>();
        for (User user: list) {
            sort.add(user);
        }
        return sort;
    }
    public List<User> sortNameLength(List<User> list) {
        List<User> sort = list;
        sort.sort();
        return sort;
    }
    public List<User> sortByAllFields (List<User> list) {
        List<User> sort = list;
        return sort;
    }
}
