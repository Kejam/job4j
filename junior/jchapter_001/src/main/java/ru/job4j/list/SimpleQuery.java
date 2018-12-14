package ru.job4j.list;

/**
 * This class implements simple queue.
 * @param <T>
 */
public class SimpleQuery<T> {
    private SimpleStack<T> stack = new SimpleStack<>();
    private SimpleStack<T> result = new SimpleStack<>();
    private int size;

    /**
     * Push int stack.
     * @param value
     */
    public void push(T value) {
        stack.push(value);
        this.size++;
    }

    /**
     * Return first value and delete this value.
     * @return
     */
    public T poll() {
        return result.poll();
    }

    /**
     * Rewrtie this stack without first element.
     * @param list
     * @return
     */
    private SimpleStack<T> convert(SimpleStack<T> list) {
        for (int i = 0; i < this.size; i++) {
            result.push(stack.poll());
        }
        return result;
    }
}
