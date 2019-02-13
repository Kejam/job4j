package job4j;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyBeanTest {
    @Test
    public void init() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        MyBean bean = (MyBean) context.getBean("myBean");
        MyBean bean1 = context.getBean(MyBean.class);
        bean.setName("alex");
        bean.sayName2();
        bean1.setName("Kate");
        bean1.sayName2();
    }
}
