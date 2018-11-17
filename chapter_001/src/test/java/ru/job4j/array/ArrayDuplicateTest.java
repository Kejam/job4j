package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.collection.IsArrayContainingInAnyOrder.arrayContainingInAnyOrder;
import static org.junit.Assert.assertThat;

public class ArrayDuplicateTest {
    @Test
    public void whenArrayHasOneDuplicateThenThree() {
        String[] actual = {"Вася", "Петя", "Петя", "Ольга"};
        String[] expected = {"Вася", "Петя", "Ольга"};
        ArrayDuplicate ar = new ArrayDuplicate();
        actual = ar.remove(actual);
        assertThat(actual, arrayContainingInAnyOrder(expected));
    }
    @Test
    public void whenArrayHasFourDuplicateThenFour() {
        String[] actual = {"Вася", "Петя", "Петя", "Ольга", "Александр", "Александр", "Ольга", "Ольга", "Петя"};
        String[] expected = {"Вася", "Петя", "Ольга", "Александр"};
        ArrayDuplicate ar = new ArrayDuplicate();
        actual = ar.remove(actual);
        assertThat(actual, arrayContainingInAnyOrder(expected));
    }
}
