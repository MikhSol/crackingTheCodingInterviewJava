package main;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GraphTest {
    private Graph gr;
    private Node node;
    private Node c;
    private Node b;

    @BeforeEach
    void setUp() {
        gr = new Graph();
        node = new Node("A");
        c = new Node("B");
        b = new Node("B");
    }

    @Test
    void testNewGraph() {
        assertTrue(gr instanceof Graph);
    }

    @Test
    void testNewNode() {
        assertTrue(node instanceof Node);
    }

    @Test
    void testNodesHasChildes() {
        node.childes.add(c);
        assertFalse(node.childes.isEmpty());
        assertEquals(1, node.childes.size());
        assertEquals(c, node.childes.get(0));
    }

    @Test
    void testGraphHasNodes () {
        gr.nodes.add(c);
        assertFalse(gr.nodes.isEmpty());
        assertEquals(1, gr.nodes.size());
        assertEquals(c, gr.nodes.get(0));
    }

    @Test
    void testNodeHasValue() {
        assertEquals("A", node.value);
    }

    @Test
    void testNodeHasLeftNode() {
        node.left = b;
        assertEquals(b, node.left);
    }

    @Test
    void testNodeHasRightNode() {
        node.right = b;
        assertEquals(b, node.right);
    }
}
