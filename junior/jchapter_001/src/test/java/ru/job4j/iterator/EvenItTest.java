package ru.job4j.iterator;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class EvenItTest {

    private EvenIt it;

    @Before
    public void setUp(){
        it = new EvenIt(new int[] {1,2,3,4,5,6});
    }

    @Test
    public void whenRetrunThreeElement() {
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(6));
    }
}
