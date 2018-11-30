package ru.job4j.list;

import java.util.*;

public class UserSort {
    public Set<User> sort(List<User> list) {
        TreeSet<User> userSet = new TreeSet<User>(list);
        return userSet;
    }
    public List<User> sortNameLength(List<User> list) {
        List<User> sort = list;
        sort.sort(
                new Comparator<User>() {
                    @Override
                    public int compare(User o1, User o2) {
                        return Integer.compare(o1.getName().length(), o2.getName().length());
                    }
                }
        );
        return sort;
    }
    public List<User> sortByAllFields(List<User> list) {
        List<User> sort = list;
        sort.sort(
                new Comparator<User>() {
                    @Override
                    public int compare(User o1, User o2) {
                        int value = o1.getName().compareTo(o2.getName());
                        if (value == 0) {
                            value = Integer.compare(o1.getAge(), o2.getAge());
                        }
                        return value;
                    }
                }
        );
        return sort;
    }
}
