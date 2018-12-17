package ru.job4j.list;

public class SimpleStack<E> extends SimpleArrayList<E> {
    DynContListS<E> list = new DynContListS<>();
    public E poll() {
        E result = list.get(getSize() - 1);
        list.delete();
        return result;
    }
    public void push(E value) {
        list.add(value);
    }
}
