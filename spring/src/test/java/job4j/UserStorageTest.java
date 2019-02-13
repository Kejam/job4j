package job4j;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;

public class UserStorageTest {
    private ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");

    @Test
    public void add() {
        Storage memory = new MemoryStorage();
        UserStorage storage = new UserStorage(memory);
        storage.add(new User());
    }

    @Test
    public void whenLoadContextShouldGetUserStorageBean() {
        UserStorage memory = this.context.getBean("storage", UserStorage.class);
        memory.add(new User());
        assertNotNull(memory);
    }

    @Test
    public void whenLoadContextShouldGetJdbcStorageBean() {
        UserStorage memory = this.context.getBean("jdbcStorage", UserStorage.class);
        memory.add(new User());
        assertNotNull(memory);
    }

    @Test
    public void whenAddToMemoryThenMemoryShouldReturnAddedItemById() {
        UserStorage memory = this.context.getBean("storage", UserStorage.class);
        User usr = new User();
        usr.setName("test");
        memory.add(usr);
        int id = 0;
        Assert.assertThat(memory.get(id).getName(), is(usr.getName()));
    }
}
