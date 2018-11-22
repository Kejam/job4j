package ru.job4j.strategy;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * @author Aleksey Prozorov (kejamwork@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class TriangleTest {
    @Test
    public void whenDrawTriangle() {
        Triangle t = new Triangle();
        String actual = t.draw();
        String expect = new StringBuilder()
                .append(" * ")
                .append(" ** ")
                .append("****")
                .toString();
        assertThat(actual, is(expect));
    }
}
