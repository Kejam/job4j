package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * @author Aleksey Prozorov (kejamwork@mail.ru)
 * This class return only even values.
 */
public class EvenIt implements Iterator<Integer> {
    private final int[] array;
    private int index = 0;

    public EvenIt(final int[] array) {
        this.array = array;
    }

    /**
     * Check that array isn't full and next value of array is even.
     * @return
     */
    @Override
    public boolean hasNext() {
        boolean result = false;
        while (index < array.length) {
            if (array[index] % 2 == 0) {
                result = true;
                break;
            } else {
                index++;
            }
        }
        return result;
    }

    /**
     * Catch no exception and pass the array until value isn't even.
     * @return
     */
    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return array[index++];
    }
}
