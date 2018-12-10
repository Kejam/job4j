package ru.job4j.generic;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArray<T> {

    private Object[] objects;
    private int index = 0;

    public SimpleArray(int size) {
        this.objects = new Object[size];
    }

    void add(T model) {
        objects[index++] = model;
    }

    void set(int index, T model) {
        objects[index] = model;
    }

    void delete(int index){
        System.arraycopy(objects, index, objects, index - 1, objects.length - 1);
    }

    T get(int index){
        return (T) objects[index];
    }

    Iterable<T> iterable() {
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return (index < objects.length);
            }
            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T t = (T) objects[index];
                return t;
            }
        }
    }
}
