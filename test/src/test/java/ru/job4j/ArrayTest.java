package ru.job4j;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ArrayTest {
    @Test
    public void whenTwoArrayMerge() {
        int[] arrayOne = {1, 2, 3, 4, 5};
        int[] arrayTwo = {3, 7, 9, 11, 15};
        Array array = new Array();
        int[] actual = array.mergeTwoArray(arrayOne, arrayTwo);
        int[] expect = {1, 2, 3, 4, 4, 5, 7, 9, 11, 15};
        assertThat(actual, is(expect));
    }
}
