package job4j;


import org.springframework.stereotype.Component;

@Component
public class MemoryStorage implements Storage {
    @Override
    public boolean add(User user) {
        System.out.println("Add user to memory");
        return false;
    }
}
