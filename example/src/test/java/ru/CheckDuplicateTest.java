package ru;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class CheckDuplicateTest {
    @Test
    public void whenTwoWordsAreDuplicate() {
        CheckDuplicateWords check = new CheckDuplicateWords();
        char[] oneWord = {'s', 'o', 's'};
        char[] twoWord = {'s', 'o', 's'};
        boolean actual = check.check(oneWord, twoWord);
        assertThat(actual, is(true));
    }
    @Test
    public void whenTwoWordsAreNotDuplicate() {
        CheckDuplicateWords check = new CheckDuplicateWords();
        char[] oneWord = {'s', 'o', 's'};
        char[] twoWord = {'s', 'a', 's'};
        boolean actual = check.check(oneWord, twoWord);
        assertThat(actual, is(false));
    }
    @Test
    public void whenTwoWordsAreOtherLength() {
        CheckDuplicateWords check = new CheckDuplicateWords();
        char[] oneWord = {'s', 'o', 's'};
        char[] twoWord = {'s', 'a', 's', 'a'};
        boolean actual = check.check(oneWord, twoWord);
        assertThat(actual, is(false));
    }
}
