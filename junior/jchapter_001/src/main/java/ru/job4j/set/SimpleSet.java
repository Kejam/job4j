package ru.job4j.set;

import ru.job4j.generic.SimpleArray;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Aleksey Prozorov (kejamwork@mail.ru)
 * This class implements set.
 */
public class SimpleSet<E> implements Iterable<E>{

    private int indexIt = 0;
    private int size = 10;
    SimpleArray<E> set = new SimpleArray<>(size);

    /**
     * This method add new element if set contains new element then return false,
     * also this method use @grow when set is full.
     * @param e
     * @return
     */
    public boolean add(E e) {
        boolean result = false;
        if (checkRepeat(e)) {
            return false;
        }
        if (set.size() < size) {
            set.add(e);
            result = true;
        } else {
            set.grow();
            set.add(e);
            result = true;
        }
        return result;
    }

    /**
     * If value repeat then return false.
     * @param e
     * @return
     */
    private boolean checkRepeat(E e) {
        boolean result = false;
        for (Object o : set.getObjects()) {
            if (e.equals(o)) {
                result = true;
            }
        }
        return result;
    }

    /**
     *
     * @return
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            @Override
            public boolean hasNext() {
                return (indexIt < size);
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return next();
            }
        };
    }
}
