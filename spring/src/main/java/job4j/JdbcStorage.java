package job4j;


import org.springframework.stereotype.Component;


public class JdbcStorage implements Storage {
    @Override
    public boolean add(User user) {
        System.out.println("Add user to database");
        return false;
    }
}
