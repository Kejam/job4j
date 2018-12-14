package ru.job4j.generic;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class implements simple array.
 * @param <T>
 */
public class SimpleArray<T> {

    private Object[] objects;
    private int index = 0;
    private int size;

    /**
     * Return actual index for array.
     * @return
     */
    public int getIndex() {
        return index;
    }

    /**
     * Constructor.
     * @param size
     */
    public SimpleArray(int size) {
        this.size = size;
        this.objects = new Object[size];
    }

    /**
     * Add new element in array.
     * @param model
     */
    public void add(T model) {
        objects[index++] = model;
    }

    /**
     * Set new element by index.
     * @param index
     * @param model
     */
    public void set(int index, T model) {
        objects[index] = model;
    }

    /**
     * Return size array.
     * @return
     */
    public int size() {
        return objects.length;
    }

    /**
     * Return copy array.
     * @return
     */
    public Object[] getObjects() {
        return objects;
    }

    /**
     * This method grows array if array is full.
     * @return
     */
    public boolean grow() {
        boolean result = false;
        size *= 2;
        objects = Arrays.copyOf(objects, size);
        if (size == objects.length) {
            result = true;
        }
        return result;
    }

    /**
     * Delete element in array by index,
     * copy array without this element.
     * @param index
     */
    public void delete(int index) {
        System.arraycopy(objects, index, objects, index - 1, objects.length - 1);
    }

    public int getSize() {
        return size;
    }

    /**
     * Return element by index.
     * @param index
     * @return
     */
    public T get(int index) {
        return (T) objects[index];
    }


}
