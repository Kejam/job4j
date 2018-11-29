package ru.job4j.list;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class UserSort {
    public Set<User> sort(List<User> list) {
        TreeSet<User> userSet = new TreeSet<>();
        for (User user : list) {
            userSet.add(user);
        }
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
                        return  o1.getName().compareTo(o2.getName());
                    }
                }
        );
        sort.sort(
                new Comparator<User>() {
                    @Override
                    public int compare(User o1, User o2) {
                        int id1 = Integer.valueOf(o1.getId());
                        int id2 = Integer.valueOf(o2.getId());
                        int value = 0;
                        if (id1 > id2) {
                            value = 1;
                        }
                        if (id1 < id2) {
                            value = -1;
                        }
                        return value;
                    }
                }
        );
        return sort;
    }
}
