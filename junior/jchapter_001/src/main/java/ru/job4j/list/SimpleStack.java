package ru.job4j.list;

public class SimpleStack<T> {

    private DynContListS<T> stack;

    public SimpleStack() {
        this.stack = new DynContListS<>();
    }

    public <T> Object poll() {
        return stack.delete();
    }

    public void push(T value) {
        stack.add(value);
    }
}
