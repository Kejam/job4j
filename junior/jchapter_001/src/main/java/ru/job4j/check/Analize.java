package ru.job4j.check;

import java.util.List;

/**
 * @author Aleksey Prozorov (kejamwork@mail.ru)
 * This class
 */
public class Analize {

    /**
     * This method checks changing in structure list.
     * Create new object class.
     * Then check size current list if current of size = 0 then all value deleted
     * else create foreach and check by user.
     * if method changed return true then info.changed++,
     * if previous contains user but current not contains then info.deleted++.
     * if previous not contains user but current contains then info.added++.
     * @param previous
     * @param current
     * @return
     */
    public Info diff(List<User> previous, List<User> current) {
        Info info = new Info();
        if (current.size() == 0) {
            info.added = 0;
            info.changed = 0;
            info.deleted = previous.size();
        }
        if (current.size() > 0) {
            for (User user: current) {
                if (changed(user, previous)) {
                    info.changed++;
                }
                if (!userInCur(user, current) && userInPrev(user, previous)) {
                    info.added++;
                }
                if (userInCur(user, current) && !userInPrev(user, previous)) {
                    info.deleted++;
                }
            }
        }
        return info;
    }

    /**
     * If user equals by id but not equals by name then user is change then return true;
     * @param user
     * @param previous
     * @return
     */
    private boolean changed(User user, List<User> previous) {
        boolean result = false;
        for (User user1: previous) {
            if (user.id == user1.id && !user.name.equals(user1.name)) {
                result = true;
            }
        }
        return result;
    }

    /**
     * If list previous contains user then return true;
     * @param user
     * @param previous
     * @return
     */
    private boolean userInPrev(User user, List<User> previous) {
        boolean result = false;
        for (User user1: previous) {
            if (user.id == user1.id && user.name.equals(user1.name)) {
                result = true;
            }
        }
        return result;
    }

    /**
     * If list current contains user then return true;
     * @param user
     * @param current
     * @return
     */
    private boolean userInCur(User user, List<User> current) {
        boolean result = false;
        for (User user1: current) {
            if (user.id == user1.id && user.name.equals(user1.name)) {
                result = true;
            }
        }
        return result;
    }


    /**
     * User
     */
    public static class User {
        int id;
        String name;
        User(String name, int id) {
            this.id = id;
            this.name = name;
        }
    }

    /**
     * Info
     * added - number of added user,
     * changed - number of changed user,
     * deleted - number of deleted user.
     */
    public static class Info {
        int added;
        int changed;
        int deleted;
    }

}