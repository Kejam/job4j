package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BubbleSortTest {
    @Test
    public void whenSortArrayWithTenElementsThenSortedArray() {
        BubbleSort bubbleSort = new BubbleSort();
        int[] result = {3, 54, 2, 5, 3};
        int[] expected = {2, 3, 3, 5, 54};
        bubbleSort.sort(result);
        assertThat(result, is(expected));
    }
}

