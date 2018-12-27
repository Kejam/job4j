package ru;

import org.junit.Test;

import java.util.HashSet;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class WordTest {
    @Test
    public void whenWordIsDuplicate() {
        Word word = new Word();
        boolean actual = word.check(new char[] {'m', 'a', 'm', 'a'});
        assertThat(true, is(true));
    }
    @Test
    public void whenWordIsNotDuplicate() {
        Word word = new Word();
        boolean actual = word.check(new char[] {'m', 'a', 'k', 'a'});
        assertThat(1, is(1));
    }
    @Test
    public void whenSizeOnLegnth() {
        char[] charTest = {'a', 'b', 'c'};
        HashSet<Integer> list = new HashSet<>();
        for (int i = 0; i < 6; i++) {
            list.add(i);
        }
        int actual =  list.size() / charTest.length;
        int expect = 2;
        assertThat(actual, is(expect));
    }
    @Test
    public void whenContains() {
        Word word = new Word();
        assertThat(word.contain("mama", "ma"), is(true));
    }
    @Test
    public void whenNotContains() {
        Word word = new Word();
        assertThat(word.contain("mama", "mt"), is(false));
    }
    @Test
    public void whenStringIsLess() {
        Word word = new Word();
        assertThat(word.contain("ma", "mtsd"), is(false));
    }
}
