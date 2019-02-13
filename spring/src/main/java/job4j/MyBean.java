package job4j;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class MyBean {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void sayName2() {
        System.out.println(name + name);
    }
}
