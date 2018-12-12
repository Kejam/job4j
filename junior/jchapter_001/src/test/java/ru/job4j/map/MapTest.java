package ru.job4j.map;

import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class MapTest {
    @Test
    public void whenCreateTwoUserWithoutHashcode() {
        User user = new User("Alex", 21, new GregorianCalendar(2000, 12, 12));
        User user1 = new User("Alex", 21, new GregorianCalendar(2000, 12, 12));
        Map<User, String> map = new HashMap<>();
        map.put(user, "hoho");
        map.put(user1, "hoho");
        System.out.println(map);
        System.out.println(user1.hashCode());
    }
}
