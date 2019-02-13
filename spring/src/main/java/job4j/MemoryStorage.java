package job4j;


import java.util.LinkedList;
import java.util.List;


public class MemoryStorage implements Storage {
    private List<User> list;

    public MemoryStorage() {
        this.list = new LinkedList<>();
    }

    @Override
    public void add(User user) {
        list.add(user);
    }

    @Override
    public User get(Integer id) {
        return list.get(id);
    }

    @Override
    public List<User> getAll() {
        return this.list;
    }
}
