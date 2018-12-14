package ru.job4j.list;

class Node<T> {
    public Node(T value) {
        this.value = value;
    }

    T value;
    Node<T> next;

    boolean hasCycle(Node first) {
        boolean result;
        if (first == null)
            result = false;
        Node tortoise = first;
        Node hare = first;
        while (true) {
            tortoise = tortoise.next;
            if (hare.next != null) {
                hare = hare.next;
                result = true;
            } else {
                result = false;
                break;
            }
            if ((tortoise == null) || (hare == null)) {
                result = false;
                break;
            }
            if (tortoise == hare) {
                result = true;
            }
        }
        return result;
    }
}
