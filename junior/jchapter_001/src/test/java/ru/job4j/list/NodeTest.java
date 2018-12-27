package ru.job4j.list;

import org.junit.Ignore;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class NodeTest {
    @Ignore
    @Test
    public void when() {
        Node first = new Node(1);
        Node two = new Node(2);
        Node third = new Node(3);
        Node four = new Node(4);
        assertThat(first.hasCycle(two), is(true));
    }
}
