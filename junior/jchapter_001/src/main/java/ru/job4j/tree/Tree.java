package ru.job4j.tree;

import java.util.*;

public class Tree<E extends Comparable<E>> implements SimpleTree<E> {

    private Node<E> root;
    /**
     * Constructor.
     * @param value
     */
    public Tree(E value) {
        root = new Node(value);
    }

    @Override
    public boolean add(E parent, E child) {
        boolean result = false;
        Optional<Node<E>> check = findBy(parent);
        if (check.isPresent()) {
            Node<E> parentValue = check.get();
            boolean duplicate = false;
            for (Node<E> node : parentValue.leaves()) {
                if (node.eqValue(child)) {
                    duplicate = true;
                    break;
                }
            }
            if (!duplicate) {
                parentValue.add(new Node<E>(child));
                result = true;
            }
        }
        return result;
    }

    public boolean isBinary() {
        boolean result = false;
        int count = 0;
        while (iterator().hasNext()) {
            iterator().next();
            count++;
        }
        if (count > 4) {
            result = true;
        }
        return false;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.eqValue(value)) {
                rsl = Optional.of(el);
                break;
            }
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return rsl;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Queue<Node<E>> elements = new LinkedList<>(Arrays.asList(root));
            @Override
            public boolean hasNext() {
                return !elements.isEmpty();
            }
            @Override
            public E next() {
                Node<E> res = this.elements.poll();
                elements.addAll(res.leaves());
                return res.getValue();
            }
        };
    }
}
