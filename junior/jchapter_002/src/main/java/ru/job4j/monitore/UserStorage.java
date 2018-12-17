package ru.job4j.monitore;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;
@ThreadSafe
public class UserStorage {
    @GuardedBy("this")
    List<User> list = new ArrayList<>();

    public synchronized boolean add(User user) {
        boolean result = true;
        list.add(user);
        if (!list.contains(user)) {
            result = false;
        }
        return result;
    }

    public synchronized boolean delete(User user) {
        boolean result = true;
        list.remove(user);
        if (list.contains(user)) {
            result = false;
        }
        return result;
    }

    public synchronized User get(int id) {
        User result = null;
        for (User user1: list) {
            if (user1.getId() == id) {
                result = user1;
                break;
            }
        }
        return result;
    }

    public synchronized boolean transfer(int fromId, int toId, int amount) {
        boolean result = false;
        User user1 = list.get(fromId);
        User user2 = list.get(toId);
        Optional<User> op1 = Optional.of(user1);
        Optional<User> op2 = Optional.of(user2);
        if (op1.isPresent() && op2.isPresent() && op1.get().getAmount() >= amount) {
            list.get(fromId).setAmount(list.get(fromId).getAmount() - amount);
            list.get(toId).setAmount(list.get(toId).getAmount() + amount);
            result = true;
        }
        return result;
    }
}
