package ru.job4j.check;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import java.util.Arrays;
import java.util.List;

public class AnalizeTest {
    List<Analize.User> listPrev;
    List<Analize.User> listCur;
    Analize analize;
    @Before
    public void setUp() {
        analize = new Analize();
        listPrev = Arrays.asList(
                new Analize.User("Alex", 1),
                new Analize.User("Kate", 2),
                new Analize.User("Aleksey", 3)
        );
        listCur = Arrays.asList(
                new Analize.User("Alex", 1),
                new Analize.User("Ann", 3)
        );
    }
    @Test
    public void whenOneDeleteOneChangeThen() {
        Analize.Info actual = analize.diff(listPrev, listCur);
        Analize.Info expect = new Analize.Info();
        expect.deleted = 1;
        expect.changed = 1;
        expect.added = 0;
        assertThat(actual.added, is(expect.added));
        assertThat(actual.changed, is(expect.changed));
        assertThat(actual.deleted, is(expect.deleted));
    }
}
