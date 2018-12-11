package ru.job4j.list;

import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * @author Aleksey Prozorov (kejamwork@mail.ru)
 * This class implemets dymamic container for linked list.
 */
public class DynContListS<E> implements Iterable<E>{

    private int size;
    private int indexIr = 0;
    private Node<E> first;

    /**
     * Add element in linked list.
     * @param value
     */
    public void add(E value) {
        Node<E> newLink = new Node<>(value);
        newLink.next = this.first;
        this.first = newLink;
        this.size++;
    }

    /**
     * Return element by index from linked list.
     * @param index
     * @return
     */
    public E get(int index) {
        Node<E> result = this.first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.value;
    }

    public int getSize() {
        return this.size;
    }

    /**
     * This class saves information.
     */
    private static class Node<E> {

        E value;
        Node<E> next;

        Node(E value) {
            this.value = value;
        }
    }

    /**
     * This class iterator for linked list.
     * @return
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            @Override
            public boolean hasNext() {
                return (indexIr < size);
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return get(indexIr++);
            }
        };
    }
}
