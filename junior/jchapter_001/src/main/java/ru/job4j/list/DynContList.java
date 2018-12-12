package ru.job4j.list;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * @author Aleksey Prozorov (kejamwork@mail.ru)
 * This class implemets dymamic container for array.
 */
public class DynContList<E> implements Iterable<E> {

    private Object[] list = new Object[10];
    private int index = 0;
    private int indexIr = 0;
    private int modCount = 0;

    /**
     * Add new element if array is full then array grow.
     * @param value
     * @return
     */
    public boolean add(E value) {
        boolean result = false;
        if (index < list.length) {
            list[index++] = value;
            result = true;
            modCount++;
        } else {
            grow();
            list[index++] = value;
            result = true;
            modCount++;
        }
        return result;
    }

    /**
     * Return element by index.
     * @param index
     * @return
     */
    public E get(int index) {
        return (E) list[index];
    }

    /**
     * Array increases in two times.
     */
    private void grow() {
        int size = list.length;
        size *= 2;
        list = Arrays.copyOf(list, size);
    }

    /**
     * Iterator for array.
     * @return
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            @Override
            public boolean hasNext() {
                return (indexIr < list.length);
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (E) list[indexIr++];
            }
        };
    }
}
