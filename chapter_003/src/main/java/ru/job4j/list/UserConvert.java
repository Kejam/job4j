package ru.job4j.list;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserConvert {
    public HashMap<Integer, User> process(List<User> list) {
        Map result = new HashMap<Integer, User>();
        for (User user: list) {
            result.put(user.getId(), user);
        }
        return (HashMap<Integer, User>) result;
    }
}
