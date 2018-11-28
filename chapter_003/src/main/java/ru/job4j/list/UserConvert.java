package ru.job4j.list;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserConvert {
    public HashMap<Integer, User> process(List<User> list) {
        Map result = new HashMap<Integer, User>();
        int position = 0;
        for (User user: list) {
            result.put(position++, user);
        }
        return (HashMap<Integer, User>) result;
    }
}
