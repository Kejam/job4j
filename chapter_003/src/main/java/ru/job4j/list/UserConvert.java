package ru.job4j.list;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UserConvert {
    public HashMap<String, User> process(List<User> list) {
        Map<String, User> result = list.stream().collect(Collectors.toMap(User::getId, user -> user));
        return (HashMap<String, User>) result;
    }
}
