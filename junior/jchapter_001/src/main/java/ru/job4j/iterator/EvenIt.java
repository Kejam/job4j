package ru.job4j.iterator;

import java.util.Iterator;

public class EvenIt implements Iterator {
    private final int[] array;
    private int index = 0;

    public EvenIt(final int[] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        return (index < array.length && array[index + 1] % 2 != 0);
    }

    @Override
    public Object next() {
        Object object = null;
        while (index <= array.length) {
            if (hasNext()) {
                object = array[index++];
                break;
            }
            index++;
        }
        return object;
    }
}
