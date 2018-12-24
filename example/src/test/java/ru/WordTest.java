package ru;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class WordTest {
    @Test
    public void whenWordIsDuplicate() {
        Word word = new Word();
        boolean actual = word.check(new char[] {'m','a','m','a'});
        assertThat(actual, is(true));
    }
    @Test
    public void whenWordIsNotDuplicate() {
        Word word = new Word();
        boolean actual = word.check(new char[] {'m','a','k','a'});
        assertThat(actual, is(false));
    }
}
