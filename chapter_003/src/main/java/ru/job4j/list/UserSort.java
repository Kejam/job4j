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
                        return  o1.getName().compareTo(o2.getName());
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
                        int value = 0;
                        if (o1.getName().length() > o2.getName().length()) {
                            if (o1.getAge() > o2.getAge()) {
                                value = 1;
                            } else {
                                value = -1;
                            }
                        }
                        if (o1.getName().length() < o2.getName().length()) {
                            if (o1.getAge() < o2.getAge()) {
                                value = 1;
                            } else {
                                value = -1;
                            }
                        }
                        return value;
                    }
                }
        );
        return sort;
    }
}
