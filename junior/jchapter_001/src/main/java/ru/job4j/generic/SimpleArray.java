package ru.job4j.generic;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArray<T> {

    private Object[] objects;
    private int index = 0;
    private int size;

    public int getIndex() {
        return index;
    }

    public SimpleArray(int size) {
        this.size = size;
        this.objects = new Object[size];
    }

    public void add(T model) {
        objects[index++] = model;
    }

    public void set(int index, T model) {
        objects[index] = model;
    }

    public int size() {
        return objects.length;
    }

    public Object[] getObjects() {
        return objects;
    }

    public boolean grow() {
        boolean result = false;
        size *= 2;
        objects = Arrays.copyOf(objects, size);
        if (size == objects.length) {
            result = true;
        }
        return result;
    }

    public void delete(int index) {
        System.arraycopy(objects, index, objects, index - 1, objects.length - 1);
    }

    public T get(int index) {
        return (T) objects[index];
    }


}
