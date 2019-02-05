package job4j.carStrorage.logic.interfaces;

import job4j.carStrorage.logic.items.User;
import java.util.List;

public interface StorageUser {
    boolean add(User user);
    List<User> returnAll();
    User returnById(int id);
}
