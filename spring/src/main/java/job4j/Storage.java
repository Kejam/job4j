package job4j;

import java.util.List;

public interface Storage {
    void add(User user);
    User get(Integer id);
    List<User> getAll();
}
