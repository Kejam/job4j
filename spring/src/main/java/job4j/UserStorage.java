package job4j;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserStorage {
    private final Storage storage;

    @Autowired
    public UserStorage(final Storage storage) {
        this.storage = storage;
    }

    public void add(User user) {
         storage.add(user);
    }

    public User get(int id) {
        return storage.get(id);
    }

    public List<User> getAll() {
        return storage.getAll();
    }
}
